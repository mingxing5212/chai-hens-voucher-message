/**
 * 
 */
package me.mingxing5212.chaihens.voucher.message.wechat.entity.token.server;

import org.apache.commons.lang3.StringUtils;

/**
 * @author ChengNing
 * @date   2015年1月29日
 */
public abstract class AbsServer implements IServer{


	protected String customerServerClass;
	
	public AbsServer(){
		this.customerServerClass = getCustomerServerClass();
	}
	
	public String token(){
		return server().token();
	}
	/**
	 * 得到系统可用的中控服务器
	 * @return 正在使用的中控服务器
	 */
	public IServer server(){
		if(isCustomer())
			return customerServer();
		return defaultServer();
	}
	
	/**
	 * 加载自定义中控服务器
	 * @return 自定义的中控服务器
	 */
	public IServer customerServer(){
		String className = customerServerClass;
		IServer customerServer = null;
		try {
			Class clazz = Class.forName(className);
			customerServer = (IServer)clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerServer;
	}
	
	/**
	 * 如果配置文件中配置了AccessTokenServer，那么使用客户自定义server
	 * @return 是否配置了自定义中控服务器
	 */
	public boolean isCustomer(){
		if(StringUtils.isBlank(customerServerClass))
			return false;
		return true;
	}
	
	/**
	 * 指定的默认中控服务器
	 * @return 默认的中控服务器
	 */
	public abstract IServer defaultServer() ;

	/**
	 * 自定义服务器的类
	 * @return
	 */
	protected abstract String getCustomerServerClass();
}
