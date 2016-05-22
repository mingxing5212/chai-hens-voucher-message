package me.mingxing5212.chaihens.voucher.web;

import me.mingxing5212.chaihens.voucher.message.wechat.entity.event.EventType;
import me.mingxing5212.chaihens.voucher.message.wechat.entity.menu.MenuButton;
import me.mingxing5212.chaihens.voucher.message.wechat.exception.WeChatException;
import me.mingxing5212.chaihens.voucher.message.wechat.request.CreateMenuRequest;
import me.mingxing5212.chaihens.voucher.message.wechat.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * WechatMenuController
 *
 * @author Mingxing Li
 * @date 22/5/16
 */
@RestController
@RequestMapping(value = "/wechat/menu")
public class WechatMenuController extends WechatBaseController{

    @Autowired
    private MenuService menuService;

    @RequestMapping(method = RequestMethod.GET)
    public String createMenu(){
        CreateMenuRequest createMenuRequest = new CreateMenuRequest();
        createMenuRequest.setAppId("wxc9f477175d656d96");
        createMenuRequest.setSecretKey("676da781f378ef3a1f747e078c385908");
        createMenuRequest.setButton(getMenuButtons());
        try {
            menuService.createMenu(createMenuRequest);
        } catch (WeChatException e) {
            e.printStackTrace();
        }
        return "";
    }

    private List<MenuButton> getMenuButtons(){
        List<MenuButton> menuButtons = new ArrayList<MenuButton>();
        MenuButton aboutMenuButton = new MenuButton();
        aboutMenuButton.setName("sss");
        aboutMenuButton.setType(EventType.CLICK);
        menuButtons.add(aboutMenuButton);
        return menuButtons;
    }
}
