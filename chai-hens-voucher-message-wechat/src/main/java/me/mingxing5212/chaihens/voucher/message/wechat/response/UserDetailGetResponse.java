package me.mingxing5212.chaihens.voucher.message.wechat.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * UserDetailGetResponse
 *
 * @author Mingxing Li
 * @date 28/5/16
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetailGetResponse extends WeChatResponse implements Serializable {

    private Integer subscribe;
    private String openid;
    private String nickname;
    private String sex;
    private String headimgurl;
    private Timestamp subscribe_time;

    public Integer getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Timestamp getSubscribe_time() {
        return subscribe_time;
    }

    public void setSubscribe_time(Timestamp subscribe_time) {
        this.subscribe_time = subscribe_time;
    }
}
