package com.yangjia33.demo.shiro;

import com.yangjia33.demo.model.Role;
import com.yangjia33.demo.model.User;
import com.yangjia33.demo.service.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author yangjia33@outlook.com
 * @version 1.0.0
 * @Description 
 * @createTime 2022-01-09 22:36
 */
public class CustomRealm extends AuthorizingRealm {

    @Resource
    LoginService loginService;
    
    /**
     * @description 权限配置类
     * @param 
     * @return 
     * @author yangjia33@outlook.com 
     * @create 2022/1/9 22:40
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取登录用户名
        String name = (String)principalCollection.getPrimaryPrincipal();
        // 查询用户
        User user = loginService.getUserByName(name);
        // 添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        for (Role role : user.getRoles()) {
            // 添加角色
            simpleAuthorizationInfo.addRole(role.getRoleName());

            // 添加权限
            role.getPermissions().forEach(v-> {
                  simpleAuthorizationInfo.addStringPermission(v.getPermissionName());
            });
        }

        return simpleAuthorizationInfo;
    }

    /**
     * @description 权限认证类
     * @param 
     * @return 
     * @author yangjia33@outlook.com 
     * @create 2022/1/9 22:41
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String name = authenticationToken.getPrincipal().toString();
        if (!StringUtils.hasText(name)){
            return null;
        }
        // 获取用户信息
        User user = loginService.getUserByName(name);
        if (user == null){
            // 这里返回后会报出对应的异常
            return null;
        }else {
            // 这里是验证authenticationToken和simpleAuthorizationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword().toString(), getName());
            return simpleAuthenticationInfo;
        }
    }
}
