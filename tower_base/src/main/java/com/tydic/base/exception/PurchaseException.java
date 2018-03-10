package com.tydic.base.exception;

/**
 * 业务异常，系统框架进行业务aop处理。
 *
 */
public class PurchaseException extends RuntimeException {
	
	private static final long serialVersionUID = 6819154425147690889L;
	
	private String msgCode;
	
	
	public String getMsgCode() {
		return msgCode;
	}
	
	public String getMsgInfo() {
		return this.getMessage();
	}
	/**
	 * 业务校验
	 * @param msgId
	 * @param message
	 */
	public PurchaseException(String msgId,String message) {
		super(message);
		this.msgCode = msgId;
	}
	public PurchaseException(String msgId,String message, Throwable cause) {
		super(message, cause);
		this.msgCode = msgId;
	}

}
