package me.mingxing5212.chaihens.voucher.message.wechat.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import me.mingxing5212.chaihens.voucher.message.wechat.entity.card.CardDetailEntity;

/**
 * CardDetailResponse
 *
 * @author Mingxing Li
 * @date 8/5/16
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDetailResponse extends WeChatResponse{
    private CardDetailEntity card;

    public CardDetailEntity getCard() {
        return card;
    }

    public void setCard(CardDetailEntity card) {
        this.card = card;
    }
}
