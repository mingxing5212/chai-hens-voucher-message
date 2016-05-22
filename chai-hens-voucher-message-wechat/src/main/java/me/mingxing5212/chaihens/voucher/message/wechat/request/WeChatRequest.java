package me.mingxing5212.chaihens.voucher.message.wechat.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 微信请求类
 *
 * @author Mingxing Li
 * @date 7/5/16
 */
public class WeChatRequest {

    @JsonIgnore
    private String appId;
    @JsonIgnore
    private String secretKey;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
