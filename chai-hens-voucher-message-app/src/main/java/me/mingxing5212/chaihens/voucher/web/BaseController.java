package me.mingxing5212.chaihens.voucher.web;

import me.mingxing5212.chaihens.domain.member.Merchant;
import me.mingxing5212.chaihens.domain.member.MerchantUser;
import me.mingxing5212.chaihens.domain.store.Store;

/**
 * Web层基类
 *
 * @author Mingxing Li
 * @date 4/4/16
 */
public class BaseController {

    protected String getAppId(){
        return "wxc9f477175d656d96";
    }

    protected String getSecretKey(){
        return "676da781f378ef3a1f747e078c385908";
    }
}
