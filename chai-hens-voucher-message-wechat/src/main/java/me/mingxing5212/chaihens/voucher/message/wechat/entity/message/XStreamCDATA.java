package me.mingxing5212.chaihens.voucher.message.wechat.entity.message;

import java.lang.annotation.ElementType;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;  
  
@Retention(RetentionPolicy.RUNTIME)  
@Target({ ElementType.FIELD })  
public @interface XStreamCDATA {  
  
} 