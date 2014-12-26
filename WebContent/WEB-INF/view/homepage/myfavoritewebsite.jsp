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
.myfavoritewebsite {
	text-align: center;
}
.submit_but {
	background: #FFF;
	cursor: pointer;
}
.myfavoritewebsite .submit_but{
	float:right;
	margin-right: 300px;
	margin-top:10px;
	margin-bottom:10px;
	border-radius:5px;
	background:#7A90C7;
	width:70px;
	height:28px;
}
.myfavoritewebsite .sitename {
	width:80px;
}
.myfavoritewebsite .siteurl {
	width:280px;
}
</style>
<script src="${ctx}/js/jquery_2.1.3.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".submit_but").click(function(){
			$(".myform").submit();
		});
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
<div class="myfavoritewebsite">
	<form class="myform" action="${ctx}/homepage/dosavewebsite.html">
	<div class="websitelist">
		网站名称：<input name="sitename" class="sitename" maxlength="8" />
		网站地址：<input name="siteurl" class="siteurl" maxlength="50"/>
	</div>
	</form>
	<input type="button" class="submit_but" value="保 存" />
	<div style="clear:both;"></div>
</div>
</div>
</body>
</html>