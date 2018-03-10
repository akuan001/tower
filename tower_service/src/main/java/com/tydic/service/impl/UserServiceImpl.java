package com.tydic.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.tydic.base.entity.OperCodeDefine;
import com.tydic.base.exception.PurchaseException;
import com.tydic.base.vo.JSONResult;
import com.tydic.base.vo.RespObjVO;
import com.tydic.bo.UsersBO;
import com.tydic.dao.UsersMapper;
import com.tydic.po.Users;
import com.tydic.po.UsersExample;
import com.tydic.service.UserService;

public class UserServiceImpl implements UserService {
    private UsersMapper usersMapper;

    @Override
    public JSONResult<UsersBO> queryUsersByName(String loginname) {
        JSONResult<UsersBO> json = new JSONResult<UsersBO>();
        UsersExample example = new UsersExample();
        example.createCriteria().andLoginnameEqualTo(loginname);
        List<Users> usersList = usersMapper.selectByExample(example);
        if (usersList.size() == 0) {
            json.setSuccess(false);
        } else {
            UsersBO usersBO = new UsersBO();
            BeanUtils.copyProperties(usersList.get(0), usersBO);
            json.setData(usersBO);
        }
        return json;
    }

    @Override
    public RespObjVO modifyUser(UsersBO usersBO) {
        RespObjVO respObjVO = new RespObjVO();
        Users users = new Users();
        users.setId(usersBO.getId());
        users.setPassword(usersBO.getPassword());
        int result = usersMapper.updateByPrimaryKeySelective(users);
        if (result < 1) {
            throw new PurchaseException(OperCodeDefine.OPER_DB_FAILED, OperCodeDefine.OPER_DB_FAILED_NAME);
        }
        return respObjVO;
    }

    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

}
