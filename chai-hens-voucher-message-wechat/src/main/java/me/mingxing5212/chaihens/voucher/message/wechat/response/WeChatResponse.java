package me.mingxing5212.chaihens.voucher.message.wechat.response;

/**
 * WeChat请求结果
 *
 * @author Mingxing Li
 * @date 24/4/16
 */
public abstract class WeChatResponse {
    private Integer errcode;
    private String errmsg;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
