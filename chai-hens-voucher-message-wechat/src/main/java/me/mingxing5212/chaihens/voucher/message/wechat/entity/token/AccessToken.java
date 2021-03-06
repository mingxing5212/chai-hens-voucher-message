/**
 * 
 */
package me.mingxing5212.chaihens.voucher.message.wechat.entity.token;

import me.mingxing5212.chaihens.voucher.message.wechat.common.Config;

/**
 * Access token实体模型
 * @author ChengNing
 * @date   2014年12月12日
 */
public class AccessToken extends Token {
	
	private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
	

	@Override
	protected String tokenName() {
		return "access_token";
	}

	@Override
	protected String expiresInName() {
		return "expires_in";
	}

	/**
	 * 组织accesstoken的请求utl
	 */
	@Override
	protected String accessTokenUrl() {
		String appid = Config.instance().getAppid();
		String appsecret = Config.instance().getAppSecret();
		String url = ACCESS_TOKEN_URL + "&appid=" + appid + "&secret=" + appsecret;
		return url;
	}
}
