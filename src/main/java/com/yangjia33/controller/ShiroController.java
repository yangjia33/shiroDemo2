package com.yangjia33.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjia33@outlook.com
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022-01-05 23:23
 */
@RestController
public class ShiroController {

    @GetMapping("hello")
    public String hello(){
        return "hello haha!";
    }
}
