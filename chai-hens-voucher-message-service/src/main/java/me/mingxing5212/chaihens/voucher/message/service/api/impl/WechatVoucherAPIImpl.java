package me.mingxing5212.chaihens.voucher.message.service.api.impl;

import me.mingxing5212.chaihens.domain.card.CashCard;
import me.mingxing5212.chaihens.domain.voucher.Voucher;
import me.mingxing5212.chaihens.exception.ServiceException;
import me.mingxing5212.chaihens.voucher.message.api.IWechatVoucherAPI;
import me.mingxing5212.chaihens.voucher.message.wechat.exception.WeChatException;
import me.mingxing5212.chaihens.voucher.message.wechat.request.CardBatchGetRequest;
import me.mingxing5212.chaihens.voucher.message.wechat.request.CardDetailRequest;
import me.mingxing5212.chaihens.voucher.message.wechat.response.CardBatchGetResponse;
import me.mingxing5212.chaihens.voucher.message.wechat.response.CardDetailResponse;
import me.mingxing5212.chaihens.voucher.message.wechat.service.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * WechatVoucherAPI
 *
 * @author Mingxing Li
 * @date 15/5/16
 */
public class WechatVoucherAPIImpl implements IWechatVoucherAPI {

    @Autowired
    private CardService cardService;

    public List<Voucher> getCashCards(Long merchantId) throws ServiceException {
        List<CashCard> cashCards = new ArrayList<CashCard>();
        CardBatchGetRequest request = new CardBatchGetRequest();
        request.setAppId("wxc9f477175d656d96");
        request.setSecretKey("676da781f378ef3a1f747e078c385908");
        request.setOffset(0);
        request.setCount(10);
        try {
            CardBatchGetResponse response = cardService.getCardList(request);
            CardDetailRequest request1 = new CardDetailRequest();
            request1.setAppId("wxc9f477175d656d96");
            request1.setSecretKey("676da781f378ef3a1f747e078c385908");
            request1.setCard_id(response.getCard_id_list()[0]);
            CardDetailResponse cardDetailResponse = cardService.getCardDetail(request1);
            //cashCards.add(cardDetailResponse.getCard());
        } catch (WeChatException e) {
            throw new ServiceException(e.getMessage());
        }
        return null;//cashCards;
    }
}
