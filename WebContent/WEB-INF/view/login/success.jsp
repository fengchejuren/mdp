<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/head.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="shortcut icon" href="${ctx}/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/main.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/easyui/themes/default/easyui.css">
<script src="${ctx}/js/jquery_2.1.3.js"></script>
<script src="${ctx}/js/easyui/jquery.easyui.min.js"></script>
<script src="${ctx}/js/easyui/jquery.validatebox.js"></script>
<script src="${ctx}/js/common.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var messages= new Array("如果您丢失了您的密码的话，可以通过验证邮箱找回。","通过验证，您可以使用用户名登陆，也可以使用邮箱登陆","为您收集您感兴趣的消息","免费发布一条广告信息");
		$(".register_success li").on({
			mousemove:function(){
				$(".register_message").html(messages[$(this).index()]);
				$(".register_message").show();
			},
			mouseout:function(){
				$(".register_message").hide();
			}
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
<div style="font-size: 18px;font-weight: bolder;color: #7A90C7;margin:10px 5px;">${user.username}:</div>
	&nbsp;&nbsp;&nbsp;&nbsp;亲，恭喜您已经完成注册。强烈建议您进行邮箱验证，以保护账户安全，获取更多服务。
	<div class="register_link"><a href="${ctx}/login/valid_email.html" >现在就验证邮箱</a></div>
	<div class="register_link"><a href="${ctx}/homepage/index.html" >暂时不验证</a></div>
<div class="dividing_line"></div>
<div class="register_success">
&nbsp;&nbsp;&nbsp;&nbsp;通过邮箱验证，您可以：<br/>
<ul>
	<li>通过邮箱找回密码</li>
	<li>使用邮箱登陆</li>
	<li>获取更多的推送消息</li>
	<li>免费发布一条广告</li>
</ul>
<div class="register_message"></div>
</div>
</div>
</body>
</html>