package me.mingxing5212.chaihens.voucher.message.wechat.service.menu;

import me.mingxing5212.chaihens.voucher.message.wechat.exception.WeChatException;
import me.mingxing5212.chaihens.voucher.message.wechat.request.CreateMenuRequest;
import me.mingxing5212.chaihens.voucher.message.wechat.response.CreateMenuResponse;
import me.mingxing5212.chaihens.voucher.message.wechat.service.WechatBaseService;
import org.springframework.stereotype.Service;

/**
 * 菜单相关服务
 *
 * @author Mingxing Li
 * @date 7/5/16
 */
@Service
public class MenuService extends WechatBaseService {

    private static final String CREATE_MENU_POST_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    public CreateMenuResponse createMenu(CreateMenuRequest createMenuRequest) throws WeChatException {
        CreateMenuResponse response = this.postForObject(CREATE_MENU_POST_URL, createMenuRequest, CreateMenuResponse.class);
        return response;
    }
}
