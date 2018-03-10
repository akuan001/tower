package com.tydic.base.exception;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;

import com.tydic.base.entity.OperCodeDefine;
import com.tydic.base.vo.RespObjVO;

public class PurchaseExceptionAdvisor implements Ordered {

    private final Log logger = LogFactory.getLog(PurchaseExceptionAdvisor.class);
    /**
     * 
     * @param pjp
     * @return
     * @throws Throwable
     */
    public Object throwAopTreat(ProceedingJoinPoint pjp) throws Throwable {
        
        RespObjVO respObj = null;
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        
        Class<?> objClass = method.getReturnType();
        respObj = (RespObjVO) objClass.newInstance();
        
        logger.info(String.format("截获对象【%s】对应方法名【%s】",methodSignature.getClass(),method.getName()));
        
        try {
            Object object = pjp.proceed();
            Field[] fields = new RespObjVO().getClass().getDeclaredFields();
            for (Field f : fields) {
                if("respCode".equals(f.getName())){
                    f.setAccessible(true);
                    f.set(object, OperCodeDefine.OPER_SUCCESS);
                }else if("respDesc".equals(f.getName())){
                    f.setAccessible(true);
                    f.set(object, OperCodeDefine.OPER_SUCCESS_NAME);
                }else if("success".equals(f.getName())){
                    f.setAccessible(true);
                    f.set(object, true);
                }
            }
            return object;
        } catch (PurchaseException e) {
            logger.error(e.getMessage(), e);
            respObj.setRespCode(e.getMsgCode());
            respObj.setRespDesc(e.getMessage());
            respObj.setSuccess(false);
        } catch (Throwable e) {
            logger.error("系统异常", e);
            respObj.setRespCode(OperCodeDefine.UNKNOW_ERROR);
            respObj.setRespDesc("系统异常");
            respObj.setSuccess(false);
        }
        
        logger.info("事物结束...");
        
        return respObj;
    }
    
    @Override
    public int getOrder() {
        return 100;
    }

}
