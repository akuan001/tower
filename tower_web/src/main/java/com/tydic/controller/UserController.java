package com.tydic.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tydic.base.entity.OperCodeDefine;
import com.tydic.base.vo.JSONResult;
import com.tydic.base.vo.RespObjVO;
import com.tydic.bo.MenuBO;
import com.tydic.bo.SystemAcctBO;
import com.tydic.bo.UsersBO;
import com.tydic.service.BusinessService;
import com.tydic.service.UserService;
import com.tydic.util.ManageUtils;
import com.tydic.vo.PassParamVO;

@Controller
@RequestMapping("/user")
public class UserController {
    private final Log logger = LogFactory.getLog(this.getClass());
    private UserService userService;
    private BusinessService businessService;

    /**
     * 用户登录
     * 
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public RespObjVO login(SystemAcctBO user, HttpServletRequest request) {
        logger.info("controller:login--------------------start");
        RespObjVO respObjVO = new RespObjVO();
        respObjVO.setSuccess(true);
        try {
            Subject subject = SecurityUtils.getSubject();
            // 已登陆则 跳到首页
            if (subject.isAuthenticated()) {
                return respObjVO;
            }
            String code = (String) request.getSession().getAttribute("validateCode");
            if (!user.getValidateCode().equalsIgnoreCase(code)) {
                respObjVO.setSuccess(false);
                respObjVO.setRespCode("0111");
                respObjVO.setRespDesc("验证码输入错误");
                subject.logout();
                return respObjVO;
            }
            // 身份验证
            subject.login(new UsernamePasswordToken(user.getLoginName(), user.getPassword()));
            JSONResult<UsersBO> jsonResult = userService.queryUsersByName(user.getLoginName());
            if (!jsonResult.isSuccess()) {
                respObjVO.setSuccess(false);
                respObjVO.setRespCode(OperCodeDefine.QUERY_DB_FAILED);
                subject.logout();
                return respObjVO;
            }
            subject.getSession().setAttribute("user", jsonResult.getData());

            JSONResult<MenuBO> json = businessService.queryMenu();
            subject.getSession().setAttribute("menu", json.getData());
        } catch (AuthenticationException e) {
            // 身份验证失败
            respObjVO.setSuccess(false);
            respObjVO.setRespCode(e.getMessage());
            return respObjVO;
        } catch (BeansException e) {
            // 数据异常
            respObjVO.setSuccess(false);
            respObjVO.setRespCode(OperCodeDefine.UNKNOW_ERROR);
            return respObjVO;
        }
        logger.info("controller:login--------------------end");
        return respObjVO;
    }

    /**
     * 用户登出
     * 
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        // 登出操作
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().removeAttribute("user");
        subject.getSession().removeAttribute("menu");

        subject.logout();
        return "redirect:/";
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    @ResponseBody
    public JSONResult<UsersBO> getAcct(HttpServletRequest request) {
        JSONResult<UsersBO> jsonResult = new JSONResult<UsersBO>();
        UsersBO user = ManageUtils.getUserInfo();
        jsonResult.setData(user);
        return jsonResult;
    }

    @RequestMapping("/modifyPass")
    public String modifyPass(ModelMap map) {
        MenuBO menu = (MenuBO) ManageUtils.getSessionValue("menu");
        if (menu == null) {
            return "redirect:/rest/user/logout";
        }
        map.put("nodeBOList", menu.getNodeBOList());
        return "common/password";
    }

    @RequestMapping(value = "/confirmModify", method = RequestMethod.POST)
    @ResponseBody
    public RespObjVO queryIndexList(HttpServletRequest request, PassParamVO passParamVO) {
        RespObjVO json = new RespObjVO();
        UsersBO user = ManageUtils.getUserInfo();
        JSONResult<UsersBO> userBOJson = userService.queryUsersByName(user.getName());
        if (!passParamVO.getPass().equals(userBOJson.getData().getPassword())) {
            // 输入的密码和原始密码不一致
            json.setRespCode("0001");
            json.setSuccess(false);
            return json;
        }
        UsersBO usersBO = new UsersBO();
        usersBO.setId(userBOJson.getData().getId());
        usersBO.setPassword(passParamVO.getSecondPass());
        RespObjVO respObjVO = userService.modifyUser(usersBO);
        return respObjVO;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
    }
}
