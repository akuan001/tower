<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<!--共用样式-->
<link rel="stylesheet" href="<c:url value="/pages/css/global.css"/>">
<!--登录样式-->
<link rel="stylesheet" href="<c:url value="/pages/css/login.css"/>">
<script src="<c:url value="/pages/plugins/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/pages/plugins/sha256/sha256.js"/>"></script>
<script src="<c:url value="/pages/plugins/jquery-validation/jquery.validate.min.js"/>"></script>
<script src="<c:url value="/pages/scripts/common/login.js"/>"></script>
<script src="<c:url value="/pages/plugins/layer/layer.js"/>"></script>
<script src="<c:url value="/pages/plugins/md5/md5.js"/>"></script>
</head>
<body>
    <input type="hidden" id="submitUrl" value="<c:url value="/rest/user/login"/>">
    <input type="hidden" id="redirectUrl" value="<c:url value="/rest/index"/>">
    <input type="hidden" id="codeUrl" value="<c:url value="/rest/page/getVerificationcode"/>">
    <!-- Begin page -->
    <div class="accountbg"></div>
    <div class="wrapper-page">
        <div class="card">
            <div class="card-block">
                <div class="logo tc">
                    <img src="<c:url value="/pages/images/login/logo.png"/>" />
                </div>
                <div class="con">
                    <form id="login-form" class="form-horizontal m-t-30">
                        <input type="hidden" id="password" name="password">
                        <div class="form-group">
                            <input id="loginName" name="loginName" type="text" class="form-control" placeholder="请输入用户名或邮箱">
                            <div style="height: 15px; color: red;"></div>
                        </div>
                        <div class="form-group">
                            <input id="passwordShow" name="passwordShow" type="password" class="form-control" placeholder="请输入密码">
                            <div style="height: 15px; color: red;"></div>
                        </div>
                        <div class="form-group">
                            <span class="input-yzm fl"> 
                                <input id="validateCode" name="validateCode" type="text" class="form-control" placeholder="请输入验证码">
                                <div style="height: 15px; color: red;"></div>
                            </span> 
                            <span class="pic-yzm fr">
                                <a href="javascript:void(0);">
                                    <img id="imageCode" src="<c:url value="/rest/page/getVerificationcode"/>" />
                                </a>
                            </span>
                        </div>
                        <!-- <div class="form-group">
                            <input class="form-check fl" name="" type="checkbox" value="" checked="checked" />自动登录
                        </div> -->
                        <div class="form-group">
                            <a id=submitBtn class="btn-login tc" href="javascript:void(0);">登录</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="m-t-40 tc copyright">
            <p>
                Copyright 2013-2017 吉林省铁塔基站用电智能监控系统 All Rights Reserved<br /> 某某网络科技有限公司提供技术支持
            </p>
        </div>
</body>
</html>
