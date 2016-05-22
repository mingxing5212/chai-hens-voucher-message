package me.mingxing5212.chaihens.voucher.message.wechat.entity.message;

public enum MsgType {
	
	Text("text"),
	Image("image"),
	Event("event");
	
	private String desc;
	MsgType(String desc){
		this.desc = desc;
	}

	@Override
	public String toString() {
		return desc;
	}
}
