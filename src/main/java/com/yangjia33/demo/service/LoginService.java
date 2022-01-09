package com.yangjia33.demo.service;

import com.yangjia33.demo.model.User;

/**
 * @author yangjia33@outlook.com
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022-01-08 16:07
 */
public interface LoginService {

    User getUserByName(String name);
}
