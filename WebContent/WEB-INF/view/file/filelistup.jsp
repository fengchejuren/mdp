<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../inc/head.inc" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源共享</title>
<link rel="stylesheet" href="${ctx}/css/main.css">
 <script src="${ctx}/js/jquery_2.1.3.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<!--侧边栏开始-->
<div class="sidebar_left">
	<img src="${ctx}/images/btn/close_icon.png" class="sidebar_close_icon" title="关闭"/>
	<div class="sidebar_content">
	    <img src="${ctx}/images/ad/ad.gif" class="sidebar_img"/>
		<div>这是一个广告</div>
	</div>
</div>
<div class="sidebar_right">
	<img src="${ctx}/images/btn/close_icon.png" class="sidebar_close_icon" title="关闭"/>
	<div class="sidebar_content">
		<img src="${ctx}/images/ad/ad.gif" class="sidebar_img"/>	
		<div>这是一个广告</div>
	</div>
</div>	    
<!--侧边栏结束-->
<!--下面是主要内容-->
<div class="content">
<!-- 导航栏 -->
<div class="navigation_bar">
<ul>
	<li><a>我的主页</a></li>
	<li><a>我的地盘</a></li>
	<li><a>新闻频道</a></li>
	<li><a>历史上的今天</a></li>
	<li><a>美文欣赏</a></li>
	<li><a href="${ctx}/file/index.html">资源共享</a></li>
	<li><a>生活助手</a></li>
</ul>
</div>
 你已成功上传文件,感谢你无私的分享.
</div>
</body>
</html>