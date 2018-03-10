package com.tydic.base.vo;



/**
 * JSONResult : Response JSONResult for RESTful,封装返回JSON格式的数据
 *
 */

public class JSONResult<T> extends RespObjVO {

    /**
     * 数据
     */
    private T data;
    
    /**
     * 请求次数
     */
    private String draw;
    /**
     * 记录总数
     */
    private int recordsTotal;
    /**
     * 过滤后记录数
     */
    private int recordsFiltered;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public JSONResult() {
        super();
    }

    /**
     * 自定义返回的结果
     *
     * @param data
     * @param respDesc
     * @param success
     */
    public JSONResult(T data, String respDesc, boolean success) {
        this.data = data;
        super.setRespDesc(respDesc);
        super.setSuccess(success);
    }

    /**
     * 成功返回数据和消息
     *
     * @param data
     * @param message
     */
    public JSONResult(T data, String respDesc) {
        this.data = data;
        super.setRespDesc(respDesc);
        super.setSuccess(true);
    }

    /**
     * 成功返回数据
     *
     * @param data
     */
    public JSONResult(T data) {
        this.data = data;
        super.setSuccess(true);
    }

	public String getDraw() {
		return draw;
	}

	public void setDraw(String draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
}