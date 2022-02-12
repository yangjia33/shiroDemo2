package com.yangjia33.demo.filter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yangjia33@outlook.com
 * @version 1.0.0
 * @Description 自定义注解
 * @createTime 2022-02-12 14:00
 */
@Target(ElementType.FIELD) // 注解用于字段上
@Retention(RetentionPolicy.RUNTIME) // 保留到运行时，可通过注解获取
public @interface MyField {
    String description();
    int length();
}
