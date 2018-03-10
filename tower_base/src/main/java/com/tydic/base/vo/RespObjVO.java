package com.tydic.base.vo;

/**
 * 返回的基类
 * 
 */
public class RespObjVO {

    // 操作码
    private String respCode;
    // 返回说明
    private String respDesc;
    // 是否成功
    private boolean success;
    
    private Object mdata;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getMdata() {
        return mdata;
    }

    public void setMdata(Object mdata) {
        this.mdata = mdata;
    }

    @Override
    public String toString() {
        return "RespObjVO [respCode=" + respCode + ", respDesc=" + respDesc + ", success=" + success + ", mdata="
                + mdata + "]";
    }

}
