<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/head.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/main.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/easyui/themes/default/easyui.css">
<script src="${ctx}/js/jquery_2.1.3.js"></script>
<script src="${ctx}/js/easyui/jquery.easyui.min.js"></script>
<script src="${ctx}/js/easyui/jquery.validatebox.js"></script>
<script src="${ctx}/js/easyui_extend.js"></script>
<script src="${ctx}/js/common.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#submitbtn").click(function(){
		if(validation()){
			$("#login_form").submit();
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
<div class="login_loginui">
<form class="login_form ui_form" action="${ctx}/login/registerCheck.html" id="login_form" method="post">
<table class="input_form_table">
	<tr>
		<td class="left">用户名：</td>
		<td class="right"><input type="text" name="username" class="input easyui-validatebox" missingMessage="请输入用户名"  required="required" /></td>
	</tr>
	<tr>
		<td class="left">密码：</td>
		<td class="right"><input type="password" name="password" class="input easyui-validatebox" id="password" required="required" missingMessage="请输入密码" /></td>
	</tr>
	<tr>
		<td class="left">重复密码：</td>
		<td class="right"><input type="password" name="repassword" class="input easyui-validatebox" required="required" missingMessage="请输入密码" validType="same['password']" /></td>
	</tr>
	<tr>
		<td class="left">常用邮箱：</td>
		<td class="right"><input type="email" name="email" class="input easyui-validatebox" required="required" validType="email" missingMessage="请输入邮箱地址" invalidMessage="你输入的邮箱不合法" /></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align: right;"><input type="button" class="submit_but" id="submitbtn" value="确定"></td>
	</tr>
</table>
</form>	
</div>
</div>
</body>
</html>