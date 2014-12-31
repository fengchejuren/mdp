<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page language="java" import="myfirst.utils.CookiesUtil" %>
<%@include file="../include/head.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的主页</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/main.css">
<link rel="stylesheet" type="text/css" href="${ctx}/js/easyui/themes/default/easyui.css">
<script src="${ctx}/js/jquery_2.1.3.js"></script>
<script src="${ctx}/js/easyui/jquery.easyui.min.js"></script>
<script src="${ctx}/js/easyui/jquery.validatebox.js"></script>
<script src="${ctx}/js/common.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
});

$("#login_form").form({
	url:"${ctx}/login/logincheck.html",
	onSubmit:function(){
		return $(this).form("validate");
	},
	success:function(data){
		$.messager.alert('Info', data, 'info');
	}
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
<form class="login_form" action="${ctx}/login/logincheck.html" id="login_form" method="post">
<table class="input_form_table">
	<tr>
		<td class="left">用户名：</td>
		<td class="right"><input type="text" name="username" class="input easyui-validatebox" missingMessage="请输入邮箱地址" invalidMessage="请检查你输入的邮箱是否合法" required="required" validType="email" /></td>
	</tr>
	<tr>
		<td class="left">密码：</td>
		<td class="right"><input type="password" name="password" class="input easyui-validatebox" required="required" /></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align: right;"><input type="submit" class="submit_but" id="submit" value="登陆"></td>
	</tr>
</table>
</form>	
</div>
</div>
</body>
</html>