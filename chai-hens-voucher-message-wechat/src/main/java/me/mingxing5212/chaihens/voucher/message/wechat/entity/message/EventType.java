package me.mingxing5212.chaihens.voucher.message.wechat.entity.message;

/**
 * EventType
 *
 * @author Mingxing Li
 * @date 22/5/16
 */
public enum EventType {
    SUBSCRIBE("subscribe"),
    UNSUBSCRIBE("unsubscribe");

    private String desc;
    EventType(String desc){
        this.desc = desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
