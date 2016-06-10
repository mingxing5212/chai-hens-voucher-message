package me.mingxing5212.chaihens.voucher.message.wechat.request;

/**
 * UserDetailGetRequest
 *
 * @author Mingxing Li
 * @date 28/5/16
 */
public class UserDetailGetRequest extends WeChatRequest{
    private String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
