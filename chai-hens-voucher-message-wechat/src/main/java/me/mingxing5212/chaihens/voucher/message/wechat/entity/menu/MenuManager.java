package me.mingxing5212.chaihens.voucher.message.wechat.entity.menu;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import me.mingxing5212.chaihens.eggs.utils.HttpClientUtils;
import me.mingxing5212.chaihens.voucher.message.wechat.exception.WeChatException;
import me.mingxing5212.chaihens.voucher.message.wechat.entity.token.TokenProxy;
import me.mingxing5212.chaihens.voucher.message.wechat.common.util.WeChatUtil;

/**
 * 微信菜单操作
 * @author Zhangxs
 * @version 2015-7-4
 */
public class MenuManager {

	private static final String MENU_CREATE_POST_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	private static final String MENU_GET_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
	private static final String MENU_DEL_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";

	private String accessToken;
	public MenuManager() {
		this.accessToken = TokenProxy.accessToken();
	}
	/**
	 * 创建菜单
	 * @throws WeChatException 
	 */
	public void create(Menu menu) throws WeChatException {
		String resultStr = HttpClientUtils.post(MENU_CREATE_POST_URL + this.accessToken, JSON.toJSONString(menu));
		WeChatUtil.isSuccess(resultStr);
	}
	
	/**
	 * 查询菜单
	 */
	public Menu getMenu() {	
		String resultStr = HttpClientUtils.get(MENU_GET_GET_URL+this.accessToken);
		try {
			WeChatUtil.isSuccess(resultStr);
		} catch (WeChatException e) {
			e.printStackTrace();
			return null;
		}
		JSONObject menuObject = JSONObject.parseObject(resultStr);
		Menu menu = menuObject.getObject("menu", Menu.class);
		return menu;
	}
	/**
	 * 删除菜单
	 * @throws WeChatException 
	 */
	public void delete() throws WeChatException{
		String resultStr = HttpClientUtils.get(MENU_DEL_GET_URL+this.accessToken);
		WeChatUtil.isSuccess(resultStr);
	}
	
}
