<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>内容</title>
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
<link rel="stylesheet" href="<c:url value="/pages/css/kkpager_blue.css"/>" />
<!--[if lt IE 9]>
	  <script src="js/html5shiv.min.js"></script>
	  <script src="js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
    <input type="hidden" id="nodecode" value="${nodecode}">
    <input type="hidden" id="login-acct" value="<c:url value="/rest/user/getUser"/>" />
    <input type="hidden" id="logout-url" value="<c:url value="/rest/user/logout"/>" />
    <input type="hidden" id="exportReportUrl" value="<c:url value="/rest/exportReport" />" />
    <input type="hidden" id="exportDownloadUrl" value="<c:url value="/rest/exportDownload"/>" />
    <input type="hidden" id="chartDayShowArrayStr" value="${chartDayShowArrayStr}">
    <input type="hidden" id="chartElecDianShowArrayStr" value="${chartElecDianShowArrayStr}">
    <input type="hidden" id="chartElecLianShowArrayStr" value="${chartElecLianShowArrayStr}">
    <input type="hidden" id="chartElecYiShowArrayStr" value="${chartElecYiShowArrayStr}">
    <input type="hidden" id="chartElecDianSum" value="${chartElecDianSum}">
    <input type="hidden" id="chartElecLianSum" value="${chartElecLianSum}">
    <input type="hidden" id="chartElecYiSum" value="${chartElecYiSum}">
    <input type="hidden" id="queryUrl" value="<c:url value="/rest/queryList"/>">
    <input type="hidden" id="currentUrl" value="<c:url value="/rest/main"/>">
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
                    <a href="javascript:void(0);" class="disabled" data-toggle="dropdown">长春 <span class="fa fa-caret-down"></span></a>
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
                            <div class="col-sm-4">
                                <p class="current">
                                    <span>当前位置：</span> <span><a href="<c:url value="/rest/index"/>">首页</a></span> <span> > </span> <span><a class="c-link" href="javascript: void(0);">${nodename}</a></span>
                                </p>
                            </div>
                            <div class="col-sm-8 text-right">
                                <form id="queryForm" method="post" action="<c:url value="/rest/main"/>?nodecode=${nodecode}" class="form-horizontal">
                                    <div class="col-sm-10 m-r-10">
                                        <div class="form-group">
                                            <div class="input-group date form_datetime col-sm-4" style="float: right;" data-link-field="dtp_input1">
                                                <input id="endTimeStr" name="endTimeStr" class="form-control" placeholder="请选择日期" size="16" type="text" value="${endTime}" readonly> <span
                                                    class="input-group-addon"> <span class="glyphicon glyphicon-th"></span>
                                                </span>
                                            </div>
                                            <span class="mlr5 lh34" style="float: right;">-</span>
                                            <div class="input-group date form_datetime col-sm-4" style="float: right;" data-link-field="dtp_input1">
                                                <input id="startTimeStr" name="startTimeStr" class="form-control" placeholder="请选择日期" size="16" type="text" value="${startTime}" readonly> <span
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
                            <div class="col-sm-6">
                                <div id="operator1" style="height: 360px"></div>
                            </div>
                            <div class="col-sm-6">
                                <div id="operator2" style="height: 360px"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--operator end-->
            <!--titlist-->
            <div class="row m-b-10">
                <div class="col-md-12">
                    <div class="titlist lh34 card">
                        <div class="row">
                            <div class="col-sm-4">
                                <p class="current">
                                    基站用电列表<span class="c-blue m-l-10">用电 <b>${elecSum}</b> 千瓦
                                    </span>
                                </p>
                            </div>
                            <div class="col-sm-8 text-right">
                                <form class="form-horizontal">
                                    <div class="btn-green-line pull-right">
                                        <a id="reloadBtn" class="btn" href="javascript:void(0);"><i class="fa fa-repeat"></i> 刷新列表</a>
                                    </div>
                                    <div class="btn-blue pull-right m-r-10">
                                        <a class="btn" id="exportBtn" href="javascript:void(0);"><i class="fa fa-file-excel-o"></i> 导出EXCEL</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--table responsive-->
            <div class="row">
                <div class="col-md-12">
                    <div class="table-responsive card">
                        <table class="table table-vertical">
                            <colgroup>
                                <col width="20">
                                <col width="100">
                                <col width="100">
                                <col width="100">
                                <col width="40">
                                <col width="20">
                            </colgroup>
                            <thead>
                                <tr>
                                    <th>编号</th>
                                    <th>传感器</th>
                                    <th>所属单位</th>
                                    <th>基站名称</th>
                                    <th>用电日期</th>
                                    <th>用电数量（千瓦）</th>
                                </tr>
                            </thead>
                            <tbody id="mainContent">
                            </tbody>
                        </table>
                        <!--page-->
                        <div id="kkpager"></div>
                        <!--page end-->
                    </div>
                </div>
            </div>
            <!--table responsive end-->
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
    <script src="<c:url value="/pages/js/kkpager.min.js"/>"></script>
    <script src="<c:url value="/pages/js/bootstrap-datetimepicker.js"/>"></script>
    <script src="<c:url value="/pages/js/bootstrap-datetimepicker.zh-CN.js"/>"></script>
    <script src="<c:url value="/pages/scripts/common/common.js"/>"></script>
    <script src="<c:url value="/pages/plugins/layer/layer.js"/>"></script>
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
    <!--operator1-->
    <script type="text/javascript">
					var chartElecDianSum = $("#chartElecDianSum").val();
					var chartElecLianSum = $("#chartElecLianSum").val();
					var chartElecYiSum = $("#chartElecYiSum").val();
					// 路径配置
					require.config({
						paths : {
							echarts : "<c:url value="/pages/build/dist"/>"
						}
					});

					// 使用
					require([ 'echarts', 'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
					], function(ec) {
						// 基于准备好的dom，初始化echarts图表
						var myChart = ec.init(document
								.getElementById('operator1'));
						option = {
							title : {
								text : '基站各运营商耗电统计',
								x : 'left'
							},
							tooltip : {
								trigger : 'item',
								formatter : "{a} <br/>{b} : {c} ({d}%)"
							},
							color : [ '#4b90ff', '#ff7f50', '#32cd32' ],
							legend : {
								orient : 'vertical',
								x : 'left',
								y : 'center',
								data : [ '中国移动', '中国电信', '中国联通' ]
							},
							toolbox : {
								show : false,
								feature : {
									mark : {
										show : true
									},
									dataView : {
										show : true,
										readOnly : false
									},
									magicType : {
										show : true,
										type : [ 'pie', 'funnel' ],
										option : {
											funnel : {
												x : '25%',
												width : '50%',
												funnelAlign : 'left',
												max : 1548
											}
										}
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
							series : [ {
								name : '访问来源',
								type : 'pie',
								radius : '70%',
								center : [ '50%', '50%' ],
								itemStyle : {
									normal : {
										label : {
											show : true,
											formatter : '{b} \n {c} \n ({d}%)'
										},
										labelLine : {
											show : true
										}
									},
								// emphasis: {  
								// label: {  
								//    show: true,  
								//    formatter: '{b} : {c} ({d}%)',
								//  position: 'center',  
								// textStyle: {  
								//   fontSize: '30',  
								//  fontWeight: 'bold'  
								// }  
								//  }  
								//   }  
								},
								data : [ {
									value : chartElecYiSum,
									name : '中国移动'
								}, {
									value : chartElecDianSum,
									name : '中国电信'
								}, {
									value : chartElecLianSum,
									name : '中国联通'
								} ]
							} ]
						};
						// 为echarts对象加载数据 
						myChart.setOption(option);
					});
				</script>
    <!--operator2-->
    <script type="text/javascript">
					var chartDayShowArrayStr = $("#chartDayShowArrayStr").val();
					var chartElecYiShowArrayStr = $("#chartElecYiShowArrayStr")
							.val();
					var chartElecDianShowArrayStr = $(
							"#chartElecDianShowArrayStr").val();
					var chartElecLianShowArrayStr = $(
							"#chartElecLianShowArrayStr").val();
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
								.getElementById('operator2'));
						option = {
							tooltip : {
								trigger : 'axis'
							},
							color : [ '#4b90ff', '#ff7f50', '#32cd32' ],
							legend : {
								data : [ '中国移动', '中国电信', '中国联通' ]
							},
							toolbox : {
								show : false,
								feature : {
									mark : {
										show : true
									},
									dataView : {
										show : true,
										readOnly : false
									},
									magicType : {
										show : true,
										type : [ 'line', 'bar', 'stack',
												'tiled' ]
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
								data : eval(chartDayShowArrayStr)
							} ],
							yAxis : [ {
								type : 'value'
							} ],
							series : [ {
								name : '中国移动',
								type : 'line',
								smooth : true,
								itemStyle : {
									normal : {
										areaStyle : {
											type : 'default'
										}
									}
								},
								data : eval(chartElecYiShowArrayStr)
							}, {
								name : '中国电信',
								type : 'line',
								smooth : true,
								itemStyle : {
									normal : {
										areaStyle : {
											type : 'default'
										}
									}
								},
								data : eval(chartElecDianShowArrayStr)
							}, {
								name : '中国联通',
								type : 'line',
								smooth : true,
								itemStyle : {
									normal : {
										areaStyle : {
											type : 'default'
										}
									}
								},
								data : eval(chartElecLianShowArrayStr)
							} ]
						};

						// 为echarts对象加载数据 
						myChart.setOption(option);
					});
				</script>
    <script type="text/javascript">
					function getParameter(name) {
						var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
						var r = window.location.search.substr(1).match(reg);
						if (r != null)
							return unescape(r[2]);
						return null;
					}
					function GetExcelTable(pageindex) {
						$
								.ajax({
									url : $("#queryUrl").val(),
									dataType : "json",
									type : "POST",
									data : {
										"pageIndex" : pageindex,
										"startTimeStr" : $("#startTimeStr")
												.val(),
										"endTimeStr" : $("#endTimeStr").val(),
										"nodecode" : $("#nodecode").val()
									},
									success : function(data) {
										if (!data.success) {
											$("#mainContent").empty();
											$("#mainContent")
													.html(
															"<div style='text-align:center; color:red'><h2>系统异常</h2></div>");
											return;
										}
										/* $("#mainContent").html(data.data); */
										var htmlVal = "";
										$.each(data.data, function(i, data) {
											var htmlStr = "<tr>" + "<td>"
													+ (i + 1) + "</td>"
													+ "<td>" + data.sensorname
													+ "</td>" + "<td>"
													+ data.teloperatorname
													+ "</td>" + "<td>"
													+ data.nodename + "</td>"
													+ "<td>"
													+ data.chargedayshow
													+ "</td>" + "<td>"
													+ data.elcunsump + "</td>"
													+ "</tr>";
											htmlVal = htmlVal + htmlStr;
										});
										$("#mainContent").html(htmlVal);
										//定义分页样式
										var totalCount = data.recordsTotal;
										if (totalCount == 0) {
											$("#mainContent").empty();
											$("#mainContent")
													.html(
															"<div style='text-align:center; color:red'><h2>暂无数据</h2></div>");
											return;
										}
										var pageSize = 10;

										var pageNo = getParameter('pageIndex');//该参数为插件自带，不设置好，调用数据的时候当前页码会一直显示在第一页

										if (!pageNo) {
											pageNo = pageindex;
										}
										var totalPages = Math
												.ceil(totalCount / 10);

										kkpager.generPageHtml({
											pno : pageNo,
											total : totalPages,
											totalRecords : totalCount,
											mode : 'click',
											click : function(n) {
												this.selectPage(pageNo);
												searchPage(n);
												return false;
											}
										}, true);
									},
									error : function(jqXHR, textStatus,
											errorThrown) {

									}
								});
					}

					//init
					$(function() {
						GetExcelTable(1);
					});
					//ajax翻页
					function searchPage(n) {
						GetExcelTable(n);
					}
				</script>
    </script>
    <script type="text/javascript">
					$(function() {
						var fileDownloadUrl = $("#exportDownloadUrl").val();
						var MainInfo = function() {
						};

						MainInfo.prototype.query = function() {
							$("#queryForm").submit();
						};

						MainInfo.prototype.reload = function() {
							location.href = $("#currentUrl").val()
									+ "?nodecode=" + $("#nodecode").val();
						};

						MainInfo.prototype.exportExcel = function() {
							layer.load(1, {
								shade : 0.3
							});
							$.ajax({
								url : $('#exportReportUrl').val(),
								dataType : "json",
								type : "POST",
								data : {
									"startTimeStr" : $("#startTimeStr").val(),
									"endTimeStr" : $("#endTimeStr").val(),
									"nodecode" : $("#nodecode").val()
								},
								success : function(data) {
									layer.closeAll();
									if (data.success) {
										location.href = fileDownloadUrl
												+ "?filePath=" + data.respDesc;
									} else {

										return false;
									}
								},
								fail : function(data) {
									layer.closeAll();
									return false;
								}
							});
						};

						MainInfo.prototype.link = function() {
							if ($(this).attr("href")) {
								location.href = $(this).attr("href");
							}
						};

						MainInfo.prototype.link2 = function() {
							if ($(this).attr("href")) {
								location.href = $(this).attr("href");
							}
						};

						$(document)
						.on('click', '#queryBtn', MainInfo.prototype.query)
						.on('click', '#reloadBtn, #refreshBtn', MainInfo.prototype.reload)
						.on('click', '#exportBtn', MainInfo.prototype.exportExcel)
						.on('click', '#menu>li>a', MainInfo.prototype.link)
						.on('click', '#menu>li>ul>li>ul>li>a', MainInfo.prototype.link2);

					});
				</script>
</body>
</html>
