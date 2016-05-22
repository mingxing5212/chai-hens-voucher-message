package me.mingxing5212.chaihens.voucher.message.wechat.exception;

/**
 * 微信请求异常
 */
public class WeChatException extends Exception {

	public WeChatException(String message){
		super(message);
	}

	public WeChatException(String message, Throwable cause){
		super(message, cause);
	}
}
