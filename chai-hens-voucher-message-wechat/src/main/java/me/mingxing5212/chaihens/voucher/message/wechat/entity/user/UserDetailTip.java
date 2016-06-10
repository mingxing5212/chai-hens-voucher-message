package me.mingxing5212.chaihens.voucher.message.wechat.entity.user;

/**
 * UserDetailTip
 *
 * @author Mingxing Li
 * @date 28/5/16
 */
public class UserDetailTip {
    private String openid;
    private String lang;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public UserDetailTip(){}

    public UserDetailTip(String openid, String lang){
        this.openid = openid;
        this.lang = lang;
    }
}
