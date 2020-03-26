package com.gxust.edu.rental_room.realm;


import com.gxust.edu.rental_room.domain.Permission;
import com.gxust.edu.rental_room.domain.Role;
import com.gxust.edu.rental_room.domain.User;
import com.gxust.edu.rental_room.exception.ExceptionKind;
import com.gxust.edu.rental_room.exception.KPException;
import com.gxust.edu.rental_room.response.ResultEnum;
import com.gxust.edu.rental_room.service.PermissionService;
import com.gxust.edu.rental_room.service.RoleService;
import com.gxust.edu.rental_room.service.UserService;
import com.gxust.edu.rental_room.utils.ResultUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义的realm
 */
public class CustomRealm extends AuthorizingRealm {

    public void setName(String name) {
        super.setName("customRealm");
    }

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;


    /**
     * 授权方法
     * 操作的时候，判断用户是否具有响应的权限
     * 先认证 -- 安全数据
     * 再授权 -- 根据安全数据获取用户具有的所有操作权限
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1.获取已认证的用户数据
        User user = (User) principalCollection.getPrimaryPrincipal();//得到唯一的安全数据
        Integer userId = user.getId();

        //TODO 根据用户id获取角色
        List<String> roles = roleService.findStringRolesByUserId(userId);
        //TODO 根据用户id获取菜单权限
        List<String> perms = permissionService.findStringPermsByUserId(userId);

        //2.根据用户数据获取用户的权限信息（所有角色，所有权限）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //TODO info.addRoles(角色集合)
        info.addRoles(roles);
        //TODO info.addStringPermissions(菜单权限集合)
        info.addStringPermissions(perms);
        /*Set<String> roles = new HashSet<>();//所有角色
        Set<String> perms = new HashSet<>();//所有权限
        for (Role role : user.getRoles()) {
            roles.add(role.getName());
            for (Permission perm : role.getPermissions()) {
//                perms.add(perm.getCode());
                perms.add(perm.getUrl());
            }
        }
        info.setStringPermissions(perms);
        info.setRoles(roles);*/
        return info;
    }


    /**
     * 认证方法
     * 参数：传递的用户名密码
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.获取登录的用户名密码（token）
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String loginName = upToken.getUsername();
        String password = new String(upToken.getPassword());
        //2.根据用户名查询数据库
        User user = userService.findByLoginName(loginName);
        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        }
        if (!user.getPassword().equals(password)) {
            throw new IncorrectCredentialsException("密码不正确");
        }
        if (!user.isStatus()) {
            throw new LockedAccountException("账户被冻结");
        }
        //3.判断用户是否存在或者密码是否一致
        //4.如果一致返回安全数据
        //构造方法：安全数据，密码，realm域名
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
        return info;
    }


    public static void main(String[] args) {
        System.out.println(new Md5Hash("123456", "lisi", 3).toString());
    }
}
