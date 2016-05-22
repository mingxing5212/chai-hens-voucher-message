/**
 * 
 */
package me.mingxing5212.chaihens.voucher.message.wechat.entity.token.timer;

import me.mingxing5212.chaihens.voucher.message.wechat.entity.token.Ticket;
import me.mingxing5212.chaihens.voucher.message.wechat.entity.token.TicketType;
import me.mingxing5212.chaihens.voucher.message.wechat.entity.token.server.CustomerServer;
import me.mingxing5212.chaihens.voucher.message.wechat.entity.token.server.JsApiTicketServer;

import java.util.TimerTask;

/**
 * @author ChengNing
 * @date 2015年1月29日
 */
public class JsApiTicketTimer extends TimerTask {

	// jsapi_ticket有效期7200秒,提前200秒请求新的token
	public static final long PERIOD = 7000 * 1000;
	public static final long DELAY = 0; // 此任务的延迟时间为0，即立即执行

	@Override
	public void run() {
		// 得到新的access token
		Ticket jsapiTicket = new Ticket(TicketType.jsapi);
		// 手动获取成功之后持久化accessToken
		if (jsapiTicket.request()) {
			JsApiTicketServer jsapiTicketServer = new JsApiTicketServer();
			CustomerServer customerServer = (CustomerServer) jsapiTicketServer
					.customerServer();
			customerServer.save(jsapiTicket);
		}
	}

}
