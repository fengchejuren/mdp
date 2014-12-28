<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/head.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的主页</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/main.css">
<style type="text/css">
a:link {
text-decoration: none;
color: #000;
}
a:visited {
text-decoration: none;
color: #000;
}
a:hover {
text-decoration: none;
color: #000;
}
a:active {
text-decoration: none;
font-size: 14px;
font-weight: bold;
color: #000;
}
.homepage_website_nav {
	background: #FFF;
	margin-top: -20px;
	padding:0 10px;
}
.homepage_website_nav ul {
	width: 100%;
	margin:0 10px 10px;
	text-align: center;
}
.homepage_website_nav li {
	width: 15%;
}
.homepage_website_nav h3 {
	margin-bottom: auto;
}
</style>
<script src="${ctx}/js/jquery_2.1.3.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	});
		
</script>
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
<ul>
<c:forEach items="${cookieList}" var="site">
	<li><a href="${site.siteurl}" target="_blank">${site.sitename}</a></li>
</c:forEach>
</ul>
<div style="clear:both;"></div></div>
</div>
</body>
</html>