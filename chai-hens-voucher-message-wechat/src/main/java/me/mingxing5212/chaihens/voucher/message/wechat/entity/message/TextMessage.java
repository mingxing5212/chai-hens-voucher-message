package me.mingxing5212.chaihens.voucher.message.wechat.entity.message;


/**
 * 文本消息
 * @author caspar.chen
 * @version 1.0
 * 
 */
public class TextMessage extends BaseMessage {
	/**
	 * 回复的消息内容
	 */
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public TextMessage(String content) {
		super();
		Content = content;
	}

	public TextMessage() {
		super();
	}
}