<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page language="java" import="myfirst.utils.CookiesUtil" %>
<%@include file="../include/head.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的主页</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/main.css">
<script src="${ctx}/js/jslib/jquery_2.1.3.js"></script>
<script src="${ctx}/js/common.js"></script>
<script src="${ctx}/js/homepage/myfavoritewebsite.js"></script>
</head>
<body>
<!-- 广告栏 -->
<%@include file="../include/ad.jsp" %>
<!--下面是主要内容-->
<div class="content">
<!-- 导航栏 -->
<%@include file="../include/navigationbar.jsp" %>
<div class="myfavoritewebsite">
	<input type="button" class="submit_but" value="保 存" />
	<div style="clear:both;"></div>
</div>
</div>
</body>
</html>