package com.tydic.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tydic.util.VerificationCodeUtil;

@Controller
@RequestMapping("/page")
public class PageController {
    /**
     * 登录页
     */
    @RequestMapping("/login")
    public String login() {
        return "common/login";
    }
    
    /**
     * 404页
     */
    @RequestMapping("/404")
    public String error404() {
        return "common/404";
    }

    /**
     * 401页
     */
    @RequestMapping("/401")
    public String error401() {
        return "common/401";
    }

    /**
     * 500页
     */
    @RequestMapping("/500")
    public String error500() {
        return "common/500";
    }
    
    /**
     * 生成验证码图片,直接以图片的格式返回客户端
     *
     * @param response
     * @param session
     */
    @RequestMapping(value = "/getVerificationcode")
    public void verificationCode(HttpServletResponse response, HttpSession session) {
        // 通过response返回给客户端
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        OutputStream ops = null;
        try {
            ops = response.getOutputStream();
            VerificationCodeUtil vcu = VerificationCodeUtil.getInstance(100, 40);
            // 将验证码保存着session会话中
            session.setAttribute("validateCode", vcu.getStr());
            ByteArrayInputStream bis = vcu.getImage();
            byte bytes[] = IOUtils.toByteArray(bis);
            ops.write(bytes);
        } catch (IOException e) {
        }
    }
}
