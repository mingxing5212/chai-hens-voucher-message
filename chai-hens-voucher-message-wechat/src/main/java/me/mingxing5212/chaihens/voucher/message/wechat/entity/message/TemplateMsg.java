/**
 * 对应接口文档地址
 * http://mp.weixin.qq.com/wiki/17/304c1885ea66dbedf7dc170d84999a9d.html
 */
package me.mingxing5212.chaihens.voucher.message.wechat.entity.message;

import com.alibaba.fastjson.JSONObject;
import me.mingxing5212.chaihens.eggs.utils.HttpClientUtils;
import me.mingxing5212.chaihens.voucher.message.wechat.entity.message.template.TemplateMsgBody;
import me.mingxing5212.chaihens.voucher.message.wechat.entity.message.template.TemplateMsgData;
import me.mingxing5212.chaihens.voucher.message.wechat.entity.token.TokenProxy;

/**
 * 模板消息接口
 * @author ChengNing
 * @date   2014年12月24日
 */
public class TemplateMsg {
	
	//设置所属行业接口地址
	public static final String SET_INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=";
	//添加模板id接口地址
	public static final String GET_TEMPLATE_ID_URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=";
	//发送模板消息接口地址
	public static final String SEND_MSG_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
	
	private String accessToken;
	
	public TemplateMsg(){
		this.accessToken = TokenProxy.accessToken();
	}
	
	/**
	 * 设置所属行业
	 * 接口说明中没有给出
	 */
	public void setIndustry(String...industrys){
		String url = SET_INDUSTRY_URL + this.accessToken;
		JSONObject json = new JSONObject();
		for(int i=0;i<industrys.length;i++){
			json.put("industry_id" + i, industrys[i]);
		}
		String data = json.toJSONString();
		HttpClientUtils.post(url, data);
	}

	/**
	 * 获得模板ID
	 * @param templateIdShort    template_id_short
	 * @return                   template_id
	 */
	public String getTemplateId(String templateIdShort){
		//构造请求数据
		String url = GET_TEMPLATE_ID_URL + this.accessToken;
		JSONObject json = new JSONObject();
		json.put("template_id_short", templateIdShort);
		String data = json.toJSONString();
		String result = HttpClientUtils.post(url, data);
		//解析请求数据
		JSONObject resultJson = JSONObject.parseObject(result);
		if(resultJson.getString("errcode").equals("0"))
			return resultJson.getString("template_id");
		return null;
	}
	
	/**
	 * 发送模板消息
	 */
	public String send(TemplateMsgBody postData){
		//构造请求数据
		String url = SEND_MSG_URL + this.accessToken;
		JSONObject json = new JSONObject();
		json.put("touser", postData.getTouser());
		json.put("template_id", postData.getTemplateId());
		json.put("url", postData.getUrl());
		json.put("topcolor", postData.getTopcolor());
		JSONObject jsonData = new JSONObject();
		for (TemplateMsgData data : postData.getData()) {
			JSONObject keynote = new JSONObject();
			keynote.put("value", data.getValue());
			keynote.put("color", data.getColor());
			jsonData.put(data.getName(), keynote);
		}
		json.put("data", jsonData);
		
		String data = json.toJSONString();
		String result = HttpClientUtils.post(url, data);
		//解析请求数据
		JSONObject resultJson = JSONObject.parseObject(result);
		if(resultJson.getString("errcode").equals("0"))
			return resultJson.getString("msgid");
		
		return null;
	}
	
	
}
