package me.mingxing5212.chaihens.voucher.message.wechat.entity.user;

import java.util.List;

/**
 * UserTip
 *
 * @author Mingxing Li
 * @date 28/5/16
 */
public class UserTip {
    private List<String> openid;

    public List<String> getOpenid() {
        return openid;
    }

    public void setOpenid(List<String> openid) {
        this.openid = openid;
    }
}
