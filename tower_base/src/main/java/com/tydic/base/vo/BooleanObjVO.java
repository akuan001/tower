package com.tydic.base.vo;

import com.tydic.base.vo.RespObjVO;

/**
 * 
 * @Description 返回的boolean校验实体
 *
 * @author  zheng
 *
 * @time  2015年12月29日 下午3:53:29
 *
 */
public class BooleanObjVO extends RespObjVO{

	private boolean exist;

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	
}
