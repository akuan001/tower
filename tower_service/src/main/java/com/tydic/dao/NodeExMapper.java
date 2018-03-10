package com.tydic.dao;

import java.util.List;

import com.tydic.base.feature.orm.mybatis.Page;
import com.tydic.bo.NodeParamBO;
import com.tydic.po.NodeEx;

public interface NodeExMapper {
    
    List<NodeEx> selectByParam(Page<NodeEx> page, NodeParamBO nodeParamBO);
}