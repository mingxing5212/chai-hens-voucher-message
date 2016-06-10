package me.mingxing5212.chaihens.voucher.message.wechat.request;

import me.mingxing5212.chaihens.voucher.message.wechat.entity.user.UserDetailTip;

import java.util.List;

/**
 * UserDetailBatchGetRequest
 *
 * @author Mingxing Li
 * @date 28/5/16
 */
public class UserDetailBatchGetRequest extends WeChatRequest{
    private List<UserDetailTip> user_list;

    public List<UserDetailTip> getUser_list() {
        return user_list;
    }

    public void setUser_list(List<UserDetailTip> user_list) {
        this.user_list = user_list;
    }
}
