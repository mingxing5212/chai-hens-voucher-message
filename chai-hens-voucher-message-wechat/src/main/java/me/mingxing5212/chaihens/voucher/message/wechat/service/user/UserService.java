package me.mingxing5212.chaihens.voucher.message.wechat.service.user;

import me.mingxing5212.chaihens.voucher.message.wechat.exception.WeChatException;
import me.mingxing5212.chaihens.voucher.message.wechat.request.UserBatchGetRequest;
import me.mingxing5212.chaihens.voucher.message.wechat.request.UserDetailBatchGetRequest;
import me.mingxing5212.chaihens.voucher.message.wechat.request.UserDetailGetRequest;
import me.mingxing5212.chaihens.voucher.message.wechat.response.UserBatchGetResponse;
import me.mingxing5212.chaihens.voucher.message.wechat.response.UserDetailBatchGetResponse;
import me.mingxing5212.chaihens.voucher.message.wechat.response.UserDetailGetResponse;
import me.mingxing5212.chaihens.voucher.message.wechat.service.WechatBaseService;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author Mingxing Li
 * @date 28/5/16
 */
@Service
public class UserService extends WechatBaseService{

    private static final String USER_BATCH_GET_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
    private static final String USER_COUNT_GET_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN";
    private static final String USER_DETAIL_GET_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    private static final String USER_BATCH_DETAIL_GET_URL = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";

    public UserBatchGetResponse getUserList(UserBatchGetRequest userBatchGetRequest) throws WeChatException {
        UserBatchGetResponse userBatchGetResponse = this.getForObject(USER_COUNT_GET_URL, userBatchGetRequest, UserBatchGetResponse.class);
        return userBatchGetResponse;
    }

    public UserDetailGetResponse getUserDetail(UserDetailGetRequest userDetailGetRequest) throws WeChatException {
        UserDetailGetResponse userDetailGetResponse = this.getForObject(assembleUrl(userDetailGetRequest), userDetailGetRequest, UserDetailGetResponse.class);
        return userDetailGetResponse;
    }

    public UserDetailBatchGetResponse getUserBatchDetail(UserDetailBatchGetRequest userDetailBatchGetRequest) throws WeChatException {
        UserDetailBatchGetResponse userDetailBatchGetResponse = this.postForObject(USER_BATCH_DETAIL_GET_URL, userDetailBatchGetRequest, UserDetailBatchGetResponse.class);
        return userDetailBatchGetResponse;
    }

    private String assembleUrl(UserDetailGetRequest userDetailGetRequest){
        return USER_DETAIL_GET_URL.replace("OPENID", userDetailGetRequest.getOpenId());
    }
}
