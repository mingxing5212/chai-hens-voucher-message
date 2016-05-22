/**
 * 
 */
package me.mingxing5212.chaihens.voucher.message.wechat.entity.token;

import me.mingxing5212.chaihens.voucher.message.wechat.entity.token.timer.AccessTokenTimer;
import me.mingxing5212.chaihens.voucher.message.wechat.entity.token.timer.JsApiTicketTimer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Timer;


/**
 * Access Token 监听器
 * @author ChengNing
 * @date   2015年1月8日
 */
public class TokenListener implements ServletContextListener{

	private Timer timer = null;

	public void contextInitialized(ServletContextEvent arg0) {
		timer = new Timer(true);
		//注册定时任务
		registeAccessTokenTimer();
		//注册jsapi_ticket定时器
		registeJsApiTicketTimer();
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
		timer.cancel();
	}
	
	/**
	 * 注册accessToken定时器
	 */
	private void registeAccessTokenTimer(){
		AccessTokenTimer accessTokenTimer = new AccessTokenTimer();
		timer.schedule(accessTokenTimer, AccessTokenTimer.DELAY, AccessTokenTimer.PERIOD);
	}
	
	/**
	 * 注册jsapi_ticket定时器
	 */
	private void registeJsApiTicketTimer(){
		JsApiTicketTimer jsApiTicketTimer = new JsApiTicketTimer();
		timer.schedule(jsApiTicketTimer, JsApiTicketTimer.DELAY,JsApiTicketTimer.PERIOD);
	}
	
}
