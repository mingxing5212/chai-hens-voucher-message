package me.mingxing5212.chaihens.voucher.message.wechat.jsapi;

import me.mingxing5212.chaihens.voucher.message.wechat.entity.token.TokenProxy;
import me.mingxing5212.chaihens.voucher.message.wechat.common.util.RandomStringGenerator;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * JS SDK 管理类
 * <p>参考<a href="http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html">开发文档</a></p>
 * Created by xuwen on 2015-12-11.
 */
public class JsApiManager {

    /**
     * 给需要调用JS SDK的URL签名
     *
     * @param url
     * @return
     */
    public static JsApiParam signature(String url) {
        StringBuffer signatureSource = new StringBuffer();
        String nonceStr = RandomStringGenerator.generate();
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);
        String jsapiTicket = TokenProxy.jsApiTicket();
        signatureSource.append("jsapi_ticket=").append(jsapiTicket);
        signatureSource.append("&noncestr=").append(nonceStr);
        signatureSource.append("&timestamp=").append(timestamp);
        signatureSource.append("&url=").append(url);
        String signature = DigestUtils.sha1Hex(signatureSource.toString());
        return new JsApiParam(url, jsapiTicket, nonceStr, timestamp, signature);
    }

}
