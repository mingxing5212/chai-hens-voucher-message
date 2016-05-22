package me.mingxing5212.chaihens.voucher.message.wechat.response;

/**
 * 请求Access Token请求结果
 * <p>正常情况下，微信会返回下述JSON数据包给公众号：
 * <p>{"access_token":"ACCESS_TOKEN","expires_in":7200}
 * <p>错误时微信会返回错误码等信息，JSON数据包示例如下（该示例为AppID无效错误）:
 * <p>{"errcode":40013,"errmsg":"invalid appid"}
 *
 * @author Mingxing Li
 * @date 24/4/16
 */
public class AccessTokenResponse extends WeChatResponse{
    private String access_token;
    private Integer expires_in;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
}
