package com.yangjia33.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @author yangjia33@outlook.com
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022-01-08 15:59
 */
@Data
@AllArgsConstructor
public class Role {

    private String id;
    private String roleName;

    /**
     * 角色对应的权限集合
     */
    private Set<Permissions> permissions;
}
