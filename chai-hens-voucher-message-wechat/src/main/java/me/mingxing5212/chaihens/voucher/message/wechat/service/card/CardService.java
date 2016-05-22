package me.mingxing5212.chaihens.voucher.message.wechat.service.card;

import me.mingxing5212.chaihens.voucher.message.wechat.exception.WeChatException;
import me.mingxing5212.chaihens.voucher.message.wechat.request.CardBatchGetRequest;
import me.mingxing5212.chaihens.voucher.message.wechat.request.CardDetailRequest;
import me.mingxing5212.chaihens.voucher.message.wechat.response.CardBatchGetResponse;
import me.mingxing5212.chaihens.voucher.message.wechat.response.CardDetailResponse;
import me.mingxing5212.chaihens.voucher.message.wechat.service.WechatBaseService;
import org.springframework.stereotype.Service;

/**
 * 卡券相关服务
 *
 * @author Mingxing Li
 * @date 7/5/16
 */
@Service
public class CardService extends WechatBaseService {

    private static final String CARD_BATCH_GET_URL = "https://api.weixin.qq.com/card/batchget?access_token=TOKEN";
    private static final String CARD_DEATIL_GET_URL = "https://api.weixin.qq.com/card/get?access_token=TOKEN";

    public CardBatchGetResponse getCardList(CardBatchGetRequest cardBatchGetRequest) throws WeChatException {
        CardBatchGetResponse response = this.postForObject(CARD_BATCH_GET_URL, cardBatchGetRequest, CardBatchGetResponse.class);
        return response;
    }

    public CardDetailResponse getCardDetail(CardDetailRequest cardDetailRequest) throws WeChatException {
        CardDetailResponse response = this.postForObject(CARD_DEATIL_GET_URL, cardDetailRequest, CardDetailResponse.class);
        return response;
    }
}
