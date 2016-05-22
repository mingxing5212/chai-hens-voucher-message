/**
 * 
 */
package me.mingxing5212.chaihens.voucher.message.wechat.entity.token.server;

import me.mingxing5212.chaihens.voucher.message.wechat.common.Config;

/**
 * Ticket server适配器
 * @author ChengNing
 * @date   2015年1月29日
 */
public class JsApiTicketServer extends AbsServer implements TicketServer  {


	/**
	 * 
	 */
	public String ticket() {
		return super.token();
	}

	/**
	 * 
	 */
	@Override
	protected String getCustomerServerClass() {
		return Config.instance().getJsApiTicketServer();
	}

	/**
	 * 
	 */
	@Override
	public IServer defaultServer() {
		return JsApiTicketMemServer.instance();
	}

}
