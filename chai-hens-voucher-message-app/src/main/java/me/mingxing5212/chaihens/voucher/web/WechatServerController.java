package me.mingxing5212.chaihens.voucher.web;

import org.springframework.web.bind.annotation.*;

/**
 * WechatServerController
 *
 * @author Mingxing Li
 * @date 22/5/16
 */
@RestController
@RequestMapping(value = "/wechat")
public class WechatServerController extends WechatBaseController{

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String validServerConfig(@RequestParam(value="signature", required=false) String signature,
                        @RequestParam(value="timestamp", required=false) String timestamp,
                        @RequestParam(value="nonce", required=false) String nonce,
                        @RequestParam(value="echostr", required=false) String echostr) {
        return echostr;
    }
}
