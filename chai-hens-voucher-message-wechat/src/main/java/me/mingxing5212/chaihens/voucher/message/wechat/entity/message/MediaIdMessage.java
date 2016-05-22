package me.mingxing5212.chaihens.voucher.message.wechat.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;  

public class MediaIdMessage {  
    @XStreamAlias("MediaId")  
    @XStreamCDATA  
    private String MediaId;  
  
    public String getMediaId() {  
        return MediaId;  
    }  
  
    public void setMediaId(String mediaId) {  
        MediaId = mediaId;  
    }  
  
} 
