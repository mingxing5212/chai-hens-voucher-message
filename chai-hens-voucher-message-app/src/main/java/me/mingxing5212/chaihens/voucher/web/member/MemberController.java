package me.mingxing5212.chaihens.voucher.web.member;

import me.mingxing5212.chaihens.eggs.Seed;
import me.mingxing5212.chaihens.eggs.annotation.SeedParam;
import me.mingxing5212.chaihens.voucher.message.wechat.entity.user.UserDetailTip;
import me.mingxing5212.chaihens.voucher.message.wechat.exception.WeChatException;
import me.mingxing5212.chaihens.voucher.message.wechat.request.UserBatchGetRequest;
import me.mingxing5212.chaihens.voucher.message.wechat.request.UserDetailBatchGetRequest;
import me.mingxing5212.chaihens.voucher.message.wechat.response.UserBatchGetResponse;
import me.mingxing5212.chaihens.voucher.message.wechat.response.UserDetailBatchGetResponse;
import me.mingxing5212.chaihens.voucher.message.wechat.response.UserDetailGetResponse;
import me.mingxing5212.chaihens.voucher.message.wechat.service.user.UserService;
import me.mingxing5212.chaihens.voucher.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * 会员模块
 *
 * @author Mingxing Li
 * @date 21/2/16
 */
@Controller
@RequestMapping(value = "/members")
public class MemberController extends BaseController {

    private static final String DEFAULT_LANG = "zh-CN";
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/wechat", method = RequestMethod.GET)
    public String wechat(Model model, @SeedParam Seed<UserDetailGetResponse> seed){
        List<UserDetailGetResponse> wechatFans = getWechatFans(this.getAppId(), this.getSecretKey());
        seed.setResult(wechatFans);
        seed.setActionPath("members/wechat");
        model.addAttribute("seed", seed);
        return "member/wechat";
    }

    protected List<UserDetailGetResponse> getWechatFans(String appId, String secretKey) {
        List<UserDetailGetResponse> userDetailGetResponses = new ArrayList<UserDetailGetResponse>();
        UserBatchGetRequest request = new UserBatchGetRequest();
        request.setAppId(appId);
        request.setSecretKey(secretKey);
        try {
            UserBatchGetResponse response = userService.getUserList(request);
            List<String> openIds = response.getData().getOpenid();
            UserDetailBatchGetRequest userDetailBatchGetRequest = new UserDetailBatchGetRequest();
            userDetailBatchGetRequest.setAppId(appId);
            userDetailBatchGetRequest.setSecretKey(secretKey);
            List<UserDetailTip> list = new ArrayList<UserDetailTip>();
            for (String openId : openIds) {
                list.add(new UserDetailTip(openId, DEFAULT_LANG));
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
