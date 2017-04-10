
package com.first.demo.security.realm;

import java.util.HashSet;
import java.util.Set;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.demo.pojo.system.User;
import com.first.demo.service.UserService;


/**
 * 
* @ClassName: MyShiroRealm 
* @Description: 用户的授权和认证,Shiro从从Realm获取安全数据（如用户、角色、权限）
* @author dsc
* @date 2016年6月23日
*
 */
@Service
public class MyShiroRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;
	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		//根据角色
		  String username = (String)principals.getPrimaryPrincipal();
          SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		  //返回结果[admin]
          Set<String> roles = new HashSet<String>();
      	 // User user = userService.selectByName(username);
       	User user=userService.findByUsername(username);
      	 /* Role role =  roleService.selectById(user.getRoleId());
          if(role != null) {
              roles.add(role.getRoleName());
          }*/
       	roles.add(user.getUsername());
          authorizationInfo.setRoles(roles);
//        //返回结果[resource:*, user:update,  user:*, organization:*]
//        authorizationInfo.setStringPermissions(userService.findPermissions(username));
//        return authorizationInfo;
        
        return authorizationInfo;
	}

	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String name_num_tel = (String)token.getPrincipal();//用户名
		User user = userService.findByUsername(name_num_tel);//当前用户
		if (user == null) {
			throw new UnknownAccountException();// 没找到帐号
		}
	/*	if(user.getStatus().equals("0")){//账号冻结
			throw new LockedAccountException();// 账号冻结
		}*/
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getPassword(), //密码
               // ByteSource.Util.bytes(user.getCredentialsSalt()),//使用盐加密方式  （添加用户，密码也要一致）salt=username+salt
                getName()  //realm name
        );
		return authenticationInfo;
	}

}

