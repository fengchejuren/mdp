<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page language="java" import="myfirst.utils.CookiesUtil" %>
<%@include file="../include/head.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的主页</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/main.css">
<script src="${ctx}/js/jslib/jquery_2.1.3.js"></script>
<script src="${ctx}/js/common.js"></script>
<script src="${ctx}/js/homepage/homepage_index.js"></script>
</head>
<body>
<!-- 广告栏 -->
<%@include file="../include/ad.jsp" %>
<!--下面是主要内容-->
<div class="content">
<!-- 导航栏 -->
<%@include file="../include/navigationbar.jsp" %>
<div class="homepage_website_nav">
<h3>网站导航</h3>
新闻
<ul>
	<li><a href="http://www.sina.com" target="_blank">新浪</a></li>
	<li><a href="http://www.163.com" target="_blank">网易</a></li>
	<li><a href="http://www.ifeng.com" target="_blank">凤凰网</a></li>
	<li><a href="http://www.sohu.com/" target="_blank">搜狐</a></li>
	<li><a href="http://www.people.com.cn/" target="_blank">人民网</a></li>
	<li><a href="http://www.qq.com/" target="_blank">腾讯首页</a></li>
</ul>
<div style="clear: both;"></div>
视频
<ul>
	<li><a href="http://www.sina.com" target="_blank">新浪</a></li>
	<li><a href="http://www.163.com" target="_blank">网易</a></li>
	<li><a href="http://www.ifeng.com" target="_blank">凤凰网</a></li>
	<li><a href="http://www.sohu.com/" target="_blank">搜狐</a></li>
	<li><a href="http://www.people.com.cn/" target="_blank">人民网</a></li>
	<li><a href="http://www.qq.com/" target="_blank">腾讯首页</a></li>
</ul>
<div style="clear: both;"></div>
购物
<ul>
	<li><a href="http://www.sina.com" target="_blank">新浪</a></li>
	<li><a href="http://www.163.com" target="_blank">网易</a></li>
	<li><a href="http://www.ifeng.com" target="_blank">凤凰网</a></li>
	<li><a href="http://www.sohu.com/" target="_blank">搜狐</a></li>
	<li><a href="http://www.people.com.cn/" target="_blank">人民网</a></li>
	<li><a href="http://www.qq.com/" target="_blank">腾讯首页</a></li>
</ul>
<div style="clear: both;"></div>
<h3><a href="${ctx}/homepage/myfavoritewebsite.html">我的网站<font color="#7F8D8A" size="0.9em">---戳一下,把自己喜欢的网站放上去</font></a></h3>
<ul id="mysite"></ul>
<div style="clear:both;"></div>
<!-- 新闻抓取 -->
<h3>新闻天下 <img src="${ctx}/images/btn/refresh_icon.png" style="float:right;" id="refresh_news" alt="刷新" title="刷新"/></h3>
<div id="news_content">
	<ul class="homepage_news_list">
	<c:forEach items="${crawlerVOList}" var="crawler">
		<li style="float: none;"><a href="${crawler.url}" target="_blank">${crawler.title}</a><br></li>
	</c:forEach>
	</ul>
</div>
<div style="clear:both;"></div>
</div>
</div>
</body>
</html>