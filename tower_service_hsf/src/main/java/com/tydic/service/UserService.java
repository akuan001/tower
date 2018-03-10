package com.tydic.service;

import com.tydic.base.vo.JSONResult;
import com.tydic.base.vo.RespObjVO;
import com.tydic.bo.UsersBO;

/**
 * 运营用户管理
 * 
 */
public interface UserService {
    
    public JSONResult<UsersBO> queryUsersByName(String loginname);
    
    public RespObjVO modifyUser(UsersBO usersBO);
    
    

}
