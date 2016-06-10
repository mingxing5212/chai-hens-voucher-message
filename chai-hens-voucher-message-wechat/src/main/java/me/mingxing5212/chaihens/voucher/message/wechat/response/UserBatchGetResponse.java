package me.mingxing5212.chaihens.voucher.message.wechat.response;

import me.mingxing5212.chaihens.voucher.message.wechat.entity.user.UserTip;

/**
 * UserBatchGetResponse
 *
 * @author Mingxing Li
 * @date 28/5/16
 */
public class UserBatchGetResponse  extends WeChatResponse{
    private Integer total;
    private Integer count;
    private UserTip data;
    private String next_openid;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public UserTip getData() {
        return data;
    }

    public void setData(UserTip data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }
}
