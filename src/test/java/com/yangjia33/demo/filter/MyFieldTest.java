package com.yangjia33.demo.filter;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * @author yangjia33@outlook.com
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022-02-12 14:03
 */
public class MyFieldTest {

    @MyField(description = "用户名", length = 10)
    private String userName;

    @Test
    public void testMyField(){

        // 获取类模板
        Class clz = MyFieldTest.class;

        // 获取所有字段
        for (Field f : clz.getDeclaredFields()) {
            // 判断这个字段是否有myField注解
            if(f.isAnnotationPresent(MyField.class)){
                MyField annotation = f.getAnnotation(MyField.class);
                System.out.println("字段：" + f.getName() + ", 描述：" + annotation.description() + "长度：" +annotation.length());
            }
        }

    }
}
