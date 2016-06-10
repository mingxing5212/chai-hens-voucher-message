package me.mingxing5212.chaihens.voucher.message.wechat.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * UserDetailBatchGetResponse
 *
 * @author Mingxing Li
 * @date 28/5/16
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetailBatchGetResponse extends WeChatResponse {
    private List<UserDetailGetResponse> user_info_list;

    public List<UserDetailGetResponse> getUser_info_list() {
        return user_info_list;
    }

    public void setUser_info_list(List<UserDetailGetResponse> user_info_list) {
        this.user_info_list = user_info_list;
    }
}
