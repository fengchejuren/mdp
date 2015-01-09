<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/head.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出错了！</title>
<link rel="stylesheet" href="${ctx}/css/main.css">
 <script src="${ctx}/js/jquery_2.1.3.js"></script>
 <script src="${ctx}/js/common.js"></script>
</head>
<body>
<!-- 广告侧边栏 -->
<%@include file="../include/ad.jsp" %>
<!--下面是主要内容-->
<div class="content">
<!-- 导航栏 -->
<%@include file="../include/navigationbar.jsp" %>
<div style="margin: 20px;text-align: center;">兄弟，出错了！</div>
<div style="color :red;font-weight: bolder;font-size: 22px;font-family: serif;text-align: center;">${e.message}</div>
</div>
</body>
</html>