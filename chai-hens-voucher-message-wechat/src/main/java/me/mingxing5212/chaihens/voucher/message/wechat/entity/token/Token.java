package me.mingxing5212.chaihens.voucher.message.wechat.entity.token;

import com.alibaba.fastjson.JSONObject;
import me.mingxing5212.chaihens.eggs.utils.HttpClientUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author ChengNing
 * @date   2015年1月29日
 */
public abstract class Token {

	private String token;   //token
	private int expires;         //token有效时间(秒)
	
	private long tokenTime;       //token产生时间
	private int redundance = 10*1000;  //冗余时间，提前10秒就去请求新的token
	
	/**
	 * 得到access token
	 */
	public String getToken(){
		return this.token;
	}
	
	/**
	 * 得到有效时间
	 */
	public int getExpires() {
		return expires;
	}
	
	/**
	 * 请求信的access token
	 * http请求方式: GET
		https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
		{"access_token":"ACCESS_TOKEN","expires_in":7200}
		{"errcode":40013,"errmsg":"invalid appid"}
	 */
	public boolean request(){
		String url = accessTokenUrl();
		String result = HttpClientUtils.get(url);
		if(StringUtils.isBlank(result))
			return false;
		if(!parseData(result)){
			return false;
		}
		return true;
	}
	
	/**
	 * 解析token数据
	 * @param data
	 * @return
	 */
	private boolean parseData(String data){
		JSONObject jsonObject = JSONObject.parseObject(data);
		String tokenName = tokenName();
		String expiresInName = expiresInName();
		try {
			String token = jsonObject.get(tokenName).toString();
			if(StringUtils.isBlank(token)){
				return false;
			}
			this.token = token;
			this.tokenTime = (new Date()).getTime();
			String expiresIn = jsonObject.get(expiresInName).toString();
			if(StringUtils.isBlank(expiresIn)){
				return false;
			}
			else{
				this.expires = Integer.valueOf(expiresIn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * token的参数名称
	 * @return
	 */
	protected abstract String tokenName(); 
	/**
	 * expireIn的参数名称
	 * @return
	 */
	protected abstract String expiresInName(); 

	/**
	 * 组织accesstoken的请求utl
	 * @return
	 */
	protected abstract String accessTokenUrl();
	
	/**
	 * accessToken 是否有效
	 * @return true:有效，false: 无效
	 */
	public boolean isValid(){
		//黑名单判定法
		if(StringUtils.isBlank(this.token))
			return false;
		if(this.expires <= 0)
			return false;
		//过期
		if(isExpire())
			return false;
		return true;
	}
	
	/**
	 * 是否过期
	 * @return true 过期 false：有效
	 */
	private boolean isExpire(){
		Date currentDate = new Date();
		long currentTime = currentDate.getTime();
		long expiresTime = expires * 1000 - redundance;
		//判断是否过期
		if((tokenTime + expiresTime) > currentTime)
			return false;
		return true;
	}
}
