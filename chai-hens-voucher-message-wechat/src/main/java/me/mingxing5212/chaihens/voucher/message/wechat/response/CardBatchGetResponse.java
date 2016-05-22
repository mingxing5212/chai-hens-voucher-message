package me.mingxing5212.chaihens.voucher.message.wechat.response;

/**
 * 批量查询卡券列表
 *
 * card_id_list: 卡券ID列表
 * total_num: 该商户名下卡券ID总数
 *
 * @author Mingxing Li
 * @date 7/5/16
 */
public class CardBatchGetResponse  extends WeChatResponse{

    private String[] card_id_list;
    private Integer total_num;
    private String[] card_list;

    public String[] getCard_id_list() {
        return card_id_list;
    }

    public void setCard_id_list(String[] card_id_list) {
        this.card_id_list = card_id_list;
    }

    public Integer getTotal_num() {
        return total_num;
    }

    public void setTotal_num(Integer total_num) {
        this.total_num = total_num;
    }

    public String[] getCard_list() {
        return card_list;
    }

    public void setCard_list(String[] card_list) {
        this.card_list = card_list;
    }
}
