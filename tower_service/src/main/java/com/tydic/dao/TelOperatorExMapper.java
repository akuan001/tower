package com.tydic.dao;

import java.util.List;

import com.tydic.bo.TelOperatorParamBO;
import com.tydic.po.TelOperator;

public interface TelOperatorExMapper {

    List<TelOperator> selectTelOperatorByParam(TelOperatorParamBO telOperatorParamBO);
}