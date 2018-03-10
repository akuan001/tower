package com.tydic.system.security.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.tydic.base.entity.OperCodeDefine;
import com.tydic.base.vo.JSONResult;
import com.tydic.bo.UsersBO;
import com.tydic.service.UserService;

public class SecurityRealm extends AuthorizingRealm {
    private UserService userService;

    /**
     * 权限检查
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限检查");
        return null;
    }

    /**
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String loginId = String.valueOf(token.getPrincipal());
        String staffPass = new String((char[]) token.getCredentials());
        // 通过数据库进行验证
        JSONResult<UsersBO> jsonResult = userService.queryUsersByName(loginId);
        UsersBO usersBO = jsonResult.getData();
        if (!jsonResult.isSuccess()) {
            throw new AuthenticationException(OperCodeDefine.STAFF_STATUS_UNEXIST);
        } else {
             if (!staffPass.equals(usersBO.getPassword())) {
                throw new AuthenticationException(OperCodeDefine.USER_PASSWORD_ERROR);
            }
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginId, staffPass, getName());
        return authenticationInfo;
    }

    public void clearAuthz() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
