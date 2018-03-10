package com.tydic.bo;

import com.tydic.base.vo.RespObjVO;

public class SystemAcctBO extends RespObjVO {
    private String loginName;

    private String password;

    private String validateCode;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

}