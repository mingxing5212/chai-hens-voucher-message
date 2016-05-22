package me.mingxing5212.chaihens.voucher.web;

import com.thoughtworks.xstream.XStream;
import me.mingxing5212.chaihens.voucher.message.wechat.entity.message.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * WechatServerController
 *
 * @author Mingxing Li
 * @date 22/5/16
 */
@RestController
@RequestMapping(value = "/wechat")
public class WechatMessageController extends WechatBaseController {

    private Logger logger = LoggerFactory.getLogger(WechatMessageController.class);

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String validServerConfig(@RequestParam(value = "signature", required = false) String signature,
                                    @RequestParam(value = "timestamp", required = false) String timestamp,
                                    @RequestParam(value = "nonce", required = false) String nonce,
                                    @RequestParam(value = "echostr", required = false) String echostr) {
        return echostr;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void validForPost(Model model, HttpServletRequest request, HttpServletResponse response) {
        logger.info("接收到来自微信的消息.");
        try {
            acceptWechatMessage(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void acceptWechatMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 处理接收消息
        ServletInputStream in = request.getInputStream();
        // 将POST流转换为XStream对象
        XStream xs = SerializeXmlUtil.createXstream();
        xs.processAnnotations(InputMessage.class);
        xs.processAnnotations(OutputMessage.class);
        // 将指定节点下的xml节点数据映射为对象
        xs.alias("xml", InputMessage.class);
        // 将流转换为字符串
        StringBuilder xmlMsg = new StringBuilder();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1; ) {
            xmlMsg.append(new String(b, 0, n, "UTF-8"));
        }
        // 将xml内容转换为InputMessage对象
        InputMessage inputMsg = (InputMessage) xs.fromXML(xmlMsg.toString());

        String servername = inputMsg.getToUserName();// 服务端
        String custermname = inputMsg.getFromUserName();// 客户端
        long createTime = inputMsg.getCreateTime();// 接收时间
        Long returnTime = Calendar.getInstance().getTimeInMillis() / 1000;// 返回时间

        logger.info("解析来自微信的消息:{}.", xmlMsg.toString());
        // 取得消息类型
        String msgType = inputMsg.getMsgType();
        // 根据消息类型获取对应的消息内容
        if (msgType.equals(MsgType.Text.toString())) {
            // 文本消息
            logger.info("开发者微信号：" + inputMsg.getToUserName());
            logger.info("发送方帐号：" + inputMsg.getFromUserName());
            logger.info("消息创建时间：" + inputMsg.getCreateTime() + new Date(createTime * 1000l));
            logger.info("消息内容：" + inputMsg.getContent());
            logger.info("消息Id：" + inputMsg.getMsgId());

            StringBuffer str = new StringBuffer();
            str.append("<xml>");
            str.append("<ToUserName><![CDATA[" + custermname + "]]></ToUserName>");
            str.append("<FromUserName><![CDATA[" + servername + "]]></FromUserName>");
            str.append("<CreateTime>" + returnTime + "</CreateTime>");
            str.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");
            str.append("<Content><![CDATA[你说的是：" + inputMsg.getContent() + "，吗？]]></Content>");
            str.append("</xml>");
            System.out.println(str.toString());
            response.getWriter().write(str.toString());
        }
        // 获取并返回多图片消息
        if (msgType.equals(MsgType.Image.toString())) {
            logger.info("获取多媒体信息");
            logger.info("多媒体文件id：" + inputMsg.getMediaId());
            logger.info("图片链接：" + inputMsg.getPicUrl());
            logger.info("消息id，64位整型：" + inputMsg.getMsgId());

            OutputMessage outputMsg = new OutputMessage();
            outputMsg.setFromUserName(servername);
            outputMsg.setToUserName(custermname);
            outputMsg.setCreateTime(returnTime);
            outputMsg.setMsgType(msgType);
            ImageMessage images = new ImageMessage();
            images.setMediaId(inputMsg.getMediaId());
            outputMsg.setImage(images);
            System.out.println("xml转换：/n" + xs.toXML(outputMsg));
            response.getWriter().write(xs.toXML(outputMsg));

        }
        if (msgType.equals(MsgType.Event.toString())) {
            if (inputMsg.getEvent().equals(EventType.SUBSCRIBE)) {
                logger.info("用户微信号：" + inputMsg.getFromUserName());
            }
        }
    }
}