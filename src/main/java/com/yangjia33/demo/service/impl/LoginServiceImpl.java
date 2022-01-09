package com.yangjia33.demo.service.impl;

import com.yangjia33.demo.model.Permissions;
import com.yangjia33.demo.model.Role;
import com.yangjia33.demo.model.User;
import com.yangjia33.demo.service.LoginService;
import org.springframework.stereotype.Service;

import java.security.Permission;
import java.util.HashMap;
import java.util.HashSet;


/**
 * @author yangjia33@outlook.com
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022-01-08 16:07
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public User getUserByName(String name) {
        return getMapByName(name);
    }

    private User getMapByName(String userName){
        // 权限
        Permissions queryPermission = new Permissions("1", "query");
        Permissions addPermission = new Permissions("2", "add");
        HashSet<Permissions> permissionsHashSet = new HashSet<>();
        permissionsHashSet.add(queryPermission);
        permissionsHashSet.add(addPermission);

        // 角色
        Role adminRole = new Role("1", "admin", permissionsHashSet);
        HashSet<Role> roleHashSet = new HashSet<>();
        roleHashSet.add(adminRole);

        // 新建用户
        User yangJUser = new User("1", "yangj", "secret", roleHashSet);
        HashMap<String, User> userHashMap = new HashMap<>();
        userHashMap.put(yangJUser.getUserName(), yangJUser);

        HashSet<Permissions> permissions2 = new HashSet<>();
        permissions2.add(queryPermission);
        Role userRole = new Role("2", "User", permissions2);

        HashSet<Role> roleHashSet2 = new HashSet<>();
        roleHashSet2.add(userRole);

        User zhangsan = new User("2", "zhangsan", "123456", roleHashSet2);
        userHashMap.put(zhangsan.getUserName(), zhangsan);


        return userHashMap.get(userName);
    }
}
