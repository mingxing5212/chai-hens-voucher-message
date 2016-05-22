package me.mingxing5212.chaihens.voucher.message.wechat.request;

import me.mingxing5212.chaihens.voucher.message.wechat.entity.menu.MenuButton;

import java.util.List;

/**
 * CreateMenuRequest
 *
 * @author Mingxing Li
 * @date 22/5/16
 */
public class CreateMenuRequest extends WeChatRequest {
    private List<MenuButton> button;

    public List<MenuButton> getButton() {
        return button;
    }

    public void setButton(List<MenuButton> button) {
        this.button = button;
    }
}
