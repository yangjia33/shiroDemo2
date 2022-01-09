package com.yangjia33.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import java.util.Set;

/**
 * @author yangjia33@outlook.com
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022-01-08 15:59
 */
@Data
@AllArgsConstructor
public class User {

    private String id;
    private String userName;
    private String password;

    /**
     * 用户对应的角色集合
     */
    private Set<Role> roles;
}
