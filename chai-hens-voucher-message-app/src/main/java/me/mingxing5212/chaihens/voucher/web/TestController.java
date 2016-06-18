package me.mingxing5212.chaihens.voucher.web;

import me.mingxing5212.chaihens.voucher.message.wechat.entity.user.UserDetailTip;
import me.mingxing5212.chaihens.voucher.message.wechat.exception.WeChatException;
import me.mingxing5212.chaihens.voucher.message.wechat.request.*;
import me.mingxing5212.chaihens.voucher.message.wechat.response.*;
import me.mingxing5212.chaihens.voucher.message.wechat.service.card.CardService;
import me.mingxing5212.chaihens.voucher.message.wechat.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private UserService userService;

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

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public String testUser(){
        UserBatchGetRequest request = new UserBatchGetRequest();
        request.setAppId("wxc9f477175d656d96");
        request.setSecretKey("676da781f378ef3a1f747e078c385908");
        request.setOffset(0);
        request.setCount(10);
        try {
            UserBatchGetResponse response = userService.getUserList(request);
            List<String> openIds = response.getData().getOpenid();
            for(String openId : openIds){
                UserDetailGetRequest userDetailGetRequest = new UserDetailGetRequest();
                userDetailGetRequest.setAppId("wxc9f477175d656d96");
                userDetailGetRequest.setSecretKey("676da781f378ef3a1f747e078c385908");
                userDetailGetRequest.setOpenId(openId);
                UserDetailGetResponse userDetailGetResponse = userService.getUserDetail(userDetailGetRequest);
            }
        } catch (WeChatException e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/batchuser")
    public List<UserDetailGetResponse> testBatchUser(){

        List<UserDetailGetResponse> userDetailGetResponses = new ArrayList<UserDetailGetResponse>();
        UserBatchGetRequest request = new UserBatchGetRequest();
        request.setAppId("wxc9f477175d656d96");
        request.setSecretKey("676da781f378ef3a1f747e078c385908");
        request.setOffset(0);
        request.setCount(10);
        try {
            UserBatchGetResponse response = userService.getUserList(request);
            List<String> openIds = response.getData().getOpenid();

            UserDetailBatchGetRequest userDetailBatchGetRequest = new UserDetailBatchGetRequest();
            userDetailBatchGetRequest.setAppId("wxc9f477175d656d96");
            userDetailBatchGetRequest.setSecretKey("676da781f378ef3a1f747e078c385908");
            List<UserDetailTip> list = new ArrayList<UserDetailTip>();
            for (String openId : openIds){
                list.add(new UserDetailTip(openId, "zh-CN"));
            }
            userDetailBatchGetRequest.setUser_list(list);
            UserDetailBatchGetResponse userDetailBatchGetResponse = userService.getUserBatchDetail(userDetailBatchGetRequest);
            userDetailGetResponses = userDetailBatchGetResponse.getUser_info_list();
        } catch (WeChatException e) {
            e.printStackTrace();
        }
        return userDetailGetResponses;
    }
}
