<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改密码</title>
<!--共用样式-->
<link rel="stylesheet" href="<c:url value="/pages/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/pages/css/font-awesome.min.css"/>">
<link rel="stylesheet" href="<c:url value="/pages/css/pace.css"/>">
<link rel="stylesheet" href="<c:url value="/pages/css/nanoscroller.css"/>">
<link rel="stylesheet" href="<c:url value="/pages/css/metismenu.min.css"/>">
<link rel="stylesheet" href="<c:url value="/pages/css/bootstrap-datetimepicker.css"/>">
<!--template css-->
<link rel="stylesheet" href="<c:url value="/pages/css/global.css"/>">
<link rel="stylesheet" href="<c:url value="/pages/css/style.css"/>">
</head>
<body>
    <input type="hidden" id="login-acct" value="<c:url value="/rest/user/getUser"/>" />
    <input type="hidden" id="logout-url" value="<c:url value="/rest/user/logout"/>" />
    <input type="hidden" id="currentUrl" value="<c:url value="/rest/user/modifyPass"/>">
    <input type="hidden" id="modifyUrl" value="<c:url value="/rest/user/confirmModify"/>">
    <div id="wrapper">
        <!--top bar start-->
        <div class="top-bar">
            <div class="container-fluid">
                <!--logo-->
                <div class="col-xs-6">
                    <a href="<c:url value="/rest/index"/>" class="admin-logo"> <img src="<c:url value="/pages/images/logo-lg.png"/>" alt="" />
                    </a>
                </div>
                <!--logo end-->
                <div class="row">
                    <div class="col-xs-6">
                        <ul class="list-inline top-right-nav">
                            <li class="dropdown avtar-dropdown"><a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown"> <img
                                    src="<c:url value="/pages/images/avatar.jpg"/>" class="img-circle" width="44" height="44" alt="" /> <span id="acc-name"></span>
                            </a>
                                <ul class="dropdown-menu top-dropdown">
                                    <li><a href="<c:url value="/rest/user/modifyPass"/>">修改密码</a></li>
                                </ul></li>
                            <li class="dropdown hidden-xs icon-dropdown"><a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown"> <i class="ico-news"></i> <!-- <span class="badge badge-danger">6</span> -->
                            </a></li>
                            <li class="dropdown hidden-xs icon-dropdown"><a href="javascript:void(0);" id="logout" class="dropdown-toggle" data-toggle="dropdown"> <i class="ico-close"></i>
                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- top bar end-->

        <!--left side bar panel-->
        <aside class="float-navigation light-navigation">
            <!--nav-search-->
            <div class="nav-search">
                <div class="city dropdown fl">
                    <a href="javascript:void(0);" data-toggle="dropdown">长春 <span class="fa fa-caret-down"></span></a>
                    <!-- <div class="citylist dropdown-menu top-dropdown">
                        <span class="jiantou"></span> <a href="javascript:togClose(this)"><span class="closs share10-cross"></span></a>
                        <div class="tjcity">
                            <div class="hd">
                                <h2>热门城市</h2>
                            </div>
                            <div class="bd">
                                <ul>
                                    <li><a href="#">北京</a></li>
                                    <li><a href="#">上海</a></li>
                                    <li><a href="#">广州</a></li>
                                    <li><a href="#">深圳</a></li>
                                    <li><a href="#">重庆</a></li>
                                    <li><a href="#">武汉</a></li>
                                    <li><a href="#">杭州</a></li>
                                    <li><a href="#">成都</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="qgcity">
                            <div class="hd">
                                <h2>全国城市列表</h2>
                            </div>
                            <div class="bd">
                                <dl>
                                    <dt>A</dt>
                                    <dd>
                                        <a href="#">安庆</a>
                                    </dd>
                                </dl>
                                <dl>
                                    <dt>B</dt>
                                    <dd>
                                        <a href="#">北京</a> <a href="#">蚌埠</a> <a href="#">百色</a>
                                    </dd>
                                </dl>
                                <dl>
                                    <dt>C</dt>
                                    <dd>
                                        <a href="#">重庆</a> <a href="#">成都</a> <a href="#">长沙</a> <a href="#">常州</a> <a href="#">沧州</a> <a href="#">长春</a> <a href="#">郴州</a>
                                    </dd>
                                </dl>

                                <dl>
                                    <dt>T</dt>
                                    <dd>
                                        <a href="#">太原</a> <a href="#">台州</a> <a href="#">唐山</a> <a href="#">天津</a> <a href="#">泰安</a> <a href="#">泰州</a>
                                    </dd>
                                </dl>
                                <dl>
                                    <dt>W</dt>
                                    <dd>
                                        <a href="#">武汉</a> <a href="#">温州</a> <a href="#">无锡</a> <a href="#">潍坊</a> <a href="#">乌鲁木齐</a> <a href="#">梧州</a>
                                    </dd>
                                </dl>
                            </div>
                        </div>
                    </div> -->
                </div>
                <!-- <div class="search-form hidden-xs">
            <form>
                <input type="text" class="form-control" placeholder="搜索基站名">
                <button type="button" class="btn-search"><i class="fa fa-search"></i></button>
            </form>
        </div> -->
            </div>
            <!--nav-search end-->

            <!--nav-category-->
            <div class="category">
                <div class="col-xs-4">
                    <a class="select" href="<c:url value="/rest/index"/>"><i class="nav-1"></i></a>
                </div>
                <div class="col-xs-4">
                    <!-- <a href="javascript:void(0);"><i class="nav-2"></i></a> -->
                </div>
                <div class="col-xs-4">
                    <a href="javascript:void(0);" id="refreshBtn"><i class="nav-3"></i></a>
                </div>
            </div>
            <!--nav-category end-->

            <div class="nano">
                <div class="nano-content">
                    <ul class="metisMenu nav" id="menu">
                        <c:forEach items="${nodeBOList}" var="nodeBO">
                            <li class="active"><a href="<c:url value="/rest/main"/>?nodecode=${nodeBO.nodecode}"> <i class="ico-first"></i>${nodeBO.nodename}<span class="fa arrow"></span>
                            </a>
                                <ul class="nav-second-level nav" aria-expanded="true">
                                    <c:forEach items="${nodeBO.telOperatorBOList}" var="telOperatorBO">
                                        <li><a href="javascript:void(0);">${telOperatorBO.name} <span class="fa arrow"></span>
                                        </a>
                                            <ul class="nav-third-level nav" aria-expanded="true">
                                                <c:forEach items="${telOperatorBO.sensorBOList}" var="sensorBO">
                                                    <li><a href="<c:url value="/rest/detailed"/>?nodecode=${nodeBO.nodecode}&sensorname=${sensorBO.sensorname}">${sensorBO.sensorname}</a></li>
                                                </c:forEach>
                                            </ul></li>
                                    </c:forEach>
                                </ul></li>
                        </c:forEach>
                    </ul>
                </div>
                <!--nano content-->
            </div>
            <!--nano scroll end-->
        </aside>
        <!--left side bar panel end-->

        <!--main content start-->
        <section class="main-content">
            <!--page header start-->
            <div class="row">
                <div class="col-md-12">
                    <div class="main-header lh34 card m-b-10">
                        <div class="row">
                            <div class="col-sm-4">
                                <p class="current">
                                    <span>当前位置：</span> <span><a href="<c:url value="/rest/index"/>">首页</a></span> <span> > </span> <span><a class="c-link" href="javascript: void(0);">修改密码</a></span>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--page header start end-->
            <!--electricity-->
            <div class="row">
                <div class="col-md-12">
                    <div class="electricity card" style="min-height: 500px;">
                        <h2>修改密码</h2>
                        <div class="electricity-con">
                            <form id="confirmForm" class="form-horizontal">
                                <div class="col-sm-3 m-r-10">
                                    <div class="form-group ">
                                        <input id="pass" name="pass" type="password" class="form-control" placeholder="请输入原密码">
                                        <div style="height: 15px; color: red;"></div>
                                    </div>
                                    <div class="form-group ">
                                        <input id="firstPass" name="firstPass" type="password" class="form-control" placeholder="请输入新密码">
                                        <div style="height: 15px; color: red;"></div>
                                    </div>
                                    <div class="form-group ">
                                        <input id="secondPass" name="secondPass" type="password" class="form-control" placeholder="再次输入新密码">
                                        <div style="height: 15px; color: red;"></div>
                                    </div>
                                    <div class="btn-search btn-green form-group">
                                        <a id="confirmBtn" class="btn" href="javascript:void(0);"><i class="fa"></i> 确认</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!--electricity-->
        </section>
        <!--main content start end-->
    </div>
    <!--Common plugins-->
    <script src="<c:url value="/pages/js/jquery.min.js"/>"></script>
    <script src="<c:url value="/pages/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/pages/js/pace.min.js"/>"></script>
    <script src="<c:url value="/pages/js/jquery.slimscroll.min.js"/>"></script>
    <script src="<c:url value="/pages/js/jquery.nanoscroller.min.js"/>"></script>
    <script src="<c:url value="/pages/js/metismenu.min.js"/>"></script>
    <script src="<c:url value="/pages/js/float-custom.js"/>"></script>
    <script src="<c:url value="/pages/scripts/common/common.js"/>"></script>
    <script src="<c:url value="/pages/plugins/layer/layer.js"/>"></script>
    <script src="<c:url value="/pages/plugins/md5/md5.js"/>"></script>
    <script type="text/javascript">
					$(function() {
						var PassInfo = function() {
						};

						PassInfo.prototype.reload = function() {
							location.href = $("#currentUrl").val();
						};

						PassInfo.prototype.link = function() {
							if ($(this).attr("href")) {
								location.href = $(this).attr("href");
							}
						};
						PassInfo.prototype.link2 = function() {
							if ($(this).attr("href")) {
								location.href = $(this).attr("href");
							}
						};

						PassInfo.prototype.confirm = function() {
							var pass = $.trim($("#pass").val());
							var firstPass = $.trim($("#firstPass").val());
							var secondPass = $.trim($("#secondPass").val());
							if (pass.length == 0) {
								$("#pass").next().text("原密码不能为空");
								$("#pass").focus();
								return;
							}
							if (firstPass.length == 0) {
								$("#firstPass").next().text("新密码不能为空");
								$("#firstPass").focus();
								return;
							}
							if (secondPass.length == 0) {
								$("#secondPass").next().text("新密码不能为空");
								$("#secondPass").focus();
								return;
							}
							if (firstPass != secondPass) {
								$("#secondPass").next().text("两次输入密码不一致，请重新输入");
								$("#secondPass").focus();
								return;
							}
							layer.load(1, {
								shade : 0.3
							});
							$.ajax({
								url : $("#modifyUrl").val(),
								dataType : "json",
								type : "POST",
								data : {
									"pass" : md5(pass),
									"firstPass" : md5(firstPass),
									"secondPass" : md5(secondPass)
								},
								success : function(data) {
									layer.closeAll();
									if (data.success) {
										layer.msg("密码修改成功",{icon: 1});
										$("#pass").val("");
										$("#pass").next().text("");
										$("#firstPass").val("");
										$("#firstPass").next().text("");
										$("#secondPass").val("");
										$("#secondPass").next().text("");
									} else {
										if (data.respCode == "0001") {
											layer.alert("原始密码不正确",{icon: 1});
											$("#pass").val("");
											$("#pass").focus();
										}
									}
									
								},
								error : function(jqXHR, textStatus,
										errorThrown) {

								}
							});
							/* alert(md5("test")); */
						};

						$(document).on('click', '#refreshBtn',
								PassInfo.prototype.reload).on('click',
								'#menu>li>a', PassInfo.prototype.link).on(
								'click', '#menu>li>ul>li>ul>li>a',
								PassInfo.prototype.link2).on('click',
								'#confirmBtn', PassInfo.prototype.confirm);

					});
				</script>
</body>
</html>
