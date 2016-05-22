package me.mingxing5212.chaihens.voucher.web;

import me.mingxing5212.chaihens.voucher.message.wechat.request.CardBatchGetRequest;
import me.mingxing5212.chaihens.voucher.message.wechat.request.CardDetailRequest;
import me.mingxing5212.chaihens.voucher.message.wechat.response.CardBatchGetResponse;
import me.mingxing5212.chaihens.voucher.message.wechat.response.CardDetailResponse;
import me.mingxing5212.chaihens.voucher.message.wechat.service.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author Mingxing Li
 * @date 24/4/16
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private CardService cardService;

    @RequestMapping(method = RequestMethod.GET)
    public String test(){
        try {
            CardBatchGetRequest request = new CardBatchGetRequest();
            request.setAppId("wxc9f477175d656d96");
            request.setSecretKey("676da781f378ef3a1f747e078c385908");
            request.setOffset(0);
            request.setCount(10);
            CardBatchGetResponse response = cardService.getCardList(request);
            //response.getTotal_num();
            CardDetailRequest request1 = new CardDetailRequest();
            request1.setAppId("wxc9f477175d656d96");
            request1.setSecretKey("676da781f378ef3a1f747e078c385908");
            request1.setCard_id(response.getCard_id_list()[0]);
            CardDetailResponse responsex = cardService.getCardDetail(request1);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
