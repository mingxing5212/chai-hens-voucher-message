package me.mingxing5212.chaihens.voucher.message.wechat.request;

/**
 * 卡券详情
 *
 * @author Mingxing Li
 * @date 8/5/16
 */
public class CardDetailRequest extends WeChatRequest {
    private String card_id;

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }
}
