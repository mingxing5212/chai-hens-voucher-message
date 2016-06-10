package me.mingxing5212.chaihens.voucher.message.wechat.request;

/**
 * UserBatchGetRequest
 *
 * @author Mingxing Li
 * @date 28/5/16
 */
public class UserBatchGetRequest extends WeChatRequest{
    private Integer offset;
    private Integer count;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
