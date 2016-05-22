package me.mingxing5212.chaihens.voucher.message.wechat.service;

import me.mingxing5212.chaihens.eggs.utils.HttpClientUtils;
import me.mingxing5212.chaihens.voucher.message.wechat.exception.WeChatException;
import me.mingxing5212.chaihens.voucher.message.wechat.request.WeChatRequest;
import me.mingxing5212.chaihens.voucher.message.wechat.response.AccessTokenResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

/**
 * 微信HTTP请求服务
 *
 * @author Mingxing Li
 * @date 24/4/16
 */
public abstract class WechatBaseService {

    private Logger logger = LoggerFactory.getLogger(WechatBaseService.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    protected  <T> T getForObject(String url, Class<T> responseType) throws WeChatException {
        try {
            T response = HttpClientUtils.getForObject(url, responseType);
            return response;
        } catch (Exception e) {
            logger.error("调用微信API GET数据异常. API地址:{}. 异常原因:{}.", url, e.getMessage(), e);
            throw new WeChatException("调用微信API获取数据异常!", e);
        }
    }

    protected  <T> T postForObject(String url, WeChatRequest wechatRequest, Class<T> responseType) throws WeChatException {
        try {
            T response = HttpClientUtils.postForObject(assembleUrl(url, wechatRequest), wechatRequest, responseType);
            return response;
        } catch (Exception e) {
            logger.error("调用微信API POST数据异常. API地址:{}. 异常原因:{}.", url, e.getMessage(), e);
            throw new WeChatException("调用微信API获取数据异常!", e);
        }
    }

    protected String assembleUrl(String originUrl, WeChatRequest wechatRequest) throws WeChatException {
        return originUrl.replace("TOKEN", this.getAccessToken(wechatRequest.getAppId(), wechatRequest.getSecretKey()));
    }

    private static final String ACCESS_TOKEN_GET_URL_FORMAT = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={0}&secret={1}";

    public AccessTokenResponse getWechatAccessToken(String appId, String secretKey) throws WeChatException {
        AccessTokenResponse response = this.getForObject(getAccessTokenUrl(appId, secretKey), AccessTokenResponse.class);
        return response;
    }

    private String getAccessTokenUrl(String appId, String secretKey){
        return MessageFormat.format(ACCESS_TOKEN_GET_URL_FORMAT, appId, secretKey);
    }

    /**
     * 获取商户的Token
     * @param appId
     * @param secretKey
     * @return
     */
    public String getAccessToken(String appId, String secretKey) throws WeChatException {
        logger.info("开始通过App Id获取Token. App Id:{}.", appId);
        String accessToken = redisTemplate.boundValueOps(getAccessTokenKey(appId)).get();
        if(StringUtils.isEmpty(accessToken)){
            logger.info("调用微信接口获取Token. App Id:{}.", appId);
            accessToken =  refreshAccessToken(appId, secretKey);
        }
        logger.info("通过App Id获取的Token:{}. App Id:{}.", accessToken, appId);
        return accessToken;
    }

    private String refreshAccessToken(String appId, String secretKey) throws WeChatException {
        try {
            AccessTokenResponse accessTokenResponse = getWechatAccessToken(appId, secretKey);
            String accessTokenKey = getAccessTokenKey(appId);
            redisTemplate.boundValueOps(accessTokenKey).set(accessTokenResponse.getAccess_token());
            redisTemplate.boundValueOps(accessTokenKey).expire(accessTokenResponse.getExpires_in(), TimeUnit.SECONDS);
            return accessTokenResponse.getAccess_token();
        }catch (WeChatException e){
            logger.error("刷新微信Token发生异常. 商户ID:{}, 异常原因:{}.", appId, e.getMessage(), e);
            throw e;
        }
    }

    private final String ACCESS_TOKEN_KEY_FORMAT = "ACCESS_TOKEN_{0}";

    private String getAccessTokenKey(String appId){
        return MessageFormat.format(ACCESS_TOKEN_KEY_FORMAT, appId);
    }
}
