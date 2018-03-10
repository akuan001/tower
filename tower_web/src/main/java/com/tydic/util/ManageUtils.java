package com.tydic.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.tydic.bo.UsersBO;

public class ManageUtils {

    /**
     * 根据Key值返回session中的值
     * 
     * @param <T>
     */
    public static Object getSessionValue(Object key) {
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        return subject.getSession().getAttribute(key);
    }

    /**
     * 返回当前登录用户信息
     * 
     * @return
     */
    public static UsersBO getUserInfo() {
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        UsersBO user = (UsersBO) subject.getSession().getAttribute("user");
        return user;
    }

}
