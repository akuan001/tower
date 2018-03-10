<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>详细页</title>
<!-- Common plugins -->
<link rel="stylesheet" href="<c:url value="/pages/css/bootstrap.min.css"/>">
<link rel="stylesheet" href="<c:url value="/pages/css/font-awesome.min.css"/>">
<link rel="stylesheet" href="<c:url value="/pages/css/pace.css"/>">
<link rel="stylesheet" href="<c:url value="/pages/css/nanoscroller.css"/>">
<link rel="stylesheet" href="<c:url value="/pages/css/metismenu.min.css"/>">
<link rel="stylesheet" href="<c:url value="/pages/css/bootstrap-datetimepicker.css"/>">
<!--template css-->
<link rel="stylesheet" href="<c:url value="/pages/css/global.css"/>">
<link rel="stylesheet" href="<c:url value="/pages/css/style.css"/>">
<!--[if lt IE 9]>
      <script src="js/html5shiv.min.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <input type="hidden" id="login-acct" value="<c:url value="/rest/user/getUser"/>" />
    <input type="hidden" id="logout-url" value="<c:url value="/rest/user/logout"/>" />
    <input type="hidden" id="currentUrl" value="<c:url value="/rest/detailed"/>" />
    <input type="hidden" id="calculateUrl" value="<c:url value="/rest/queryElCunsump"/>" />
    <input type="hidden" id="nodecode" value="${nodecode}">
    <input type="hidden" id="sensorname" value="${sensorname}">
    <input type="hidden" id="chartHourShowArrayStr" value="${chartHourShowArrayStr}">
    <input type="hidden" id="chartElectricityShowArrayStr" value="${chartElectricityShowArrayStr}">
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
                        <button type="button" class="btn-search">
                            <i class="fa fa-search"></i>
                        </button>
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
                            <div class="col-sm-5">
                                <p class="current">
                                    <span>当前位置：</span> <span><a href="<c:url value="/rest/index"/>">首页</a></span> <span> > </span> <span><a
                                        href="<c:url value="/rest/main"/>?nodecode=${nodecode}">${nodename}</a></span> <span> > </span> <span>${teloperatorname}</span> <span> > </span> <span><a
                                        class="c-link" href="javascript: void(0);">${sensorname}</a></span>
                                </p>
                            </div>
                            <div class="col-sm-7 text-right">
                                <form id="queryForm" method="post" action="<c:url value="/rest/detailed"/>?nodecode=${nodecode}&sensorname=${sensorname}" class="form-horizontal">
                                    <div class="col-sm-10 m-r-10">
                                        <div class="form-group">
                                            <div class="input-group date form_datetime col-sm-4" style="float: right;" data-link-field="dtp_input1">
                                                <input id="endTimeStr" name="endTimeStr" class="form-control" placeholder="请选择日期" size="16" type="text" value="${endTime}" readonly> <span
                                                    class="input-group-addon"> <span class="glyphicon glyphicon-th"></span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="btn-search btn-blue text-right fr">
                                        <a id="queryBtn" class="btn" href="javascript:void(0);"><i class="fa fa-search"></i> 查询</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--page header start end-->
            <!--operator-->
            <div class="row m-b-10">
                <div class="col-sm-12">
                    <div class="operator lh34 card">
                        <div class="row">
                            <div class="col-sm-12">
                                <div id="operator" style="height: 520px"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--operator end-->
            <!--electricity-->
            <div class="row">
                <div class="col-md-12">
                    <div class="electricity card">
                        <h2>耗电量统计（瓦时）</h2>
                        <div class="electricity-con">
                            <form class="form-horizontal">
                                <div class="col-sm-2 m-r-10">
                                    <div class="form-group">
                                        <div class="input-group date form_datetime col-sm-12" data-link-field="dtp_input1">
                                            <input id="calTimeStr" name="calTimeStr" class="form-control" placeholder="请选择日期" size="16" type="text" value="" readonly> <span
                                                class="input-group-addon"> <span class="glyphicon glyphicon-th"></span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-2 m-r-10">
                                    <div class="form-group ">
                                        <input id="showElCunsump" type="text" class="ele-form-control form-control" disabled>
                                    </div>
                                </div>
                                <div class="btn-search btn-green">
                                    <a id="calculateBtn" class="btn" href="javascript:void(0);"><i class="fa fa-calculator"></i> 计算</a>
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
    <script src="<c:url value="/pages/js/bootstrap-datetimepicker.js"/>"></script>
    <script src="<c:url value="/pages/js/bootstrap-datetimepicker.zh-CN.js"/>"></script>
    <script src="<c:url value="/pages/scripts/common/common.js"/>"></script>
    <script type="text/javascript">
					$('.form_datetime').datetimepicker({
						minView : "month",
						language : "zh-CN",
						defaultDate : new Date(),
						format : "yyyy-mm-dd",
						todayBtn : true,
						clearBtn : true,
						pickerPosition : "bottom-left"
					});
				</script>
    <!-- ECharts单文件引入 -->
    <script src="<c:url value="/pages/js/echarts.js"/>"></script>
    <!--operator-->
    <script type="text/javascript">
					var $chartHourShowArrayStr = $("#chartHourShowArrayStr")
							.val();
					var $chartElectricityShowArrayStr = $(
							"#chartElectricityShowArrayStr").val();
					// 路径配置
					require.config({
						paths : {
							echarts : "<c:url value="/pages/build/dist"/>"
						}
					});

					// 使用
					require([ 'echarts', 'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
					], function(ec) {
						// 基于准备好的dom，初始化echarts图表
						var myChart = ec.init(document
								.getElementById('operator'));
						option = {
							title : {
								text : '24小时电量统计/瓦'
							},
							tooltip : {
								trigger : 'axis'
							},
							legend : {
								data : [ '电量' ]
							},
							toolbox : {
								show : true,
								feature : {
									mark : {
										show : false
									},
									dataView : {
										show : true,
										readOnly : false
									},
									magicType : {
										show : false,
										type : [ 'line', 'bar' ]
									},
									restore : {
										show : true
									},
									saveAsImage : {
										show : true
									}
								}
							},
							calculable : true,
							xAxis : [ {
								type : 'category',
								boundaryGap : false,
								data : eval($chartHourShowArrayStr)
							} ],
							yAxis : [ {
								type : 'value',
								axisLabel : {
									formatter : '{value} 瓦'
								}
							} ],
							series : [ {
								name : '电量',
								type : 'line',
								data : eval($chartElectricityShowArrayStr),
								markPoint : {
									data : [ {
										type : 'max',
										name : '最大值'
									}, {
										type : 'min',
										name : '最小值'
									} ]
								},
								markLine : {
									data : [ {
										type : 'average',
										name : '平均值'
									} ]
								}
							} ]
						};

						// 为echarts对象加载数据 
						myChart.setOption(option);
					});
				</script>
    <script type="text/javascript">
					$(function() {
						var DetailedInfo = function() {
						};

						DetailedInfo.prototype.query = function() {
							$("#queryForm").submit();
						};
						
						DetailedInfo.prototype.reload = function() {
							location.href = $("#currentUrl").val()
									+ "?nodecode=" + $("#nodecode").val() + "&sensorname=" + $("#sensorname").val();
						};

						DetailedInfo.prototype.link = function() {
							if ($(this).attr("href")) {
								location.href = $(this).attr("href");
							}
						};
						DetailedInfo.prototype.link2 = function() {
							if ($(this).attr("href")) {
								location.href = $(this).attr("href");
							}
						};
						DetailedInfo.prototype.calculate = function() {
							$
									.ajax({
										url : $("#calculateUrl").val(),
										dataType : "json",
										type : "POST",
										data : {
											"calTimeStr" : $("#calTimeStr")
													.val(),
											"sensorname" : $("#sensorname")
													.val()
										},
										success : function(data) {
											if (data.success) {
												$("#showElCunsump").val(
														data.data);
											}
										},
										error : function(jqXHR, textStatus,
												errorThrown) {

										}
									});
						};

						$(document)
						.on('click', '#queryBtn', DetailedInfo.prototype.query)
						.on('click', '#refreshBtn', DetailedInfo.prototype.reload)
						.on('click', '#menu>li>a', DetailedInfo.prototype.link)
						.on('click', '#menu>li>ul>li>ul>li>a', DetailedInfo.prototype.link2)
						.on('click', '#calculateBtn', DetailedInfo.prototype.calculate);

					});
				</script>
</body>
</html>
