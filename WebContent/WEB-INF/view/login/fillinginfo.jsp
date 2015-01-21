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
<script language="javascript" type="text/javascript" src="${ctx}/js/My97DatePicker/WdatePicker.js"></script>
<script src="${ctx}/js/common.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#birthday").click(function(){WdatePicker();});
});
</script>
</head>
<body>
<!-- 广告栏 -->
<%@include file="../include/ad.jsp" %>
<!-- 导航栏 -->
<%@include file="../include/navigationbar.jsp" %>
<!--下面是主要内容-->
<div class="content">
<div class="login_loginui">
尊敬的${user.username}，请完善以下资料：
<form class="login_form" action="${ctx}/login/registerCheck.html" id="login_form" method="post">
<table class="input_form_table">
	<tr>
		<td class="left">性别：</td>
		<td class="right">男<input type="radio" name="sex" value="0" checked="checked">&nbsp;&nbsp;&nbsp;&nbsp;女<input type="radio" name="sex" value="1"/></td>
	</tr>
	<tr>
		<td class="left">出生日期：</td>
		<td class="right"><input name="birthday" id="birthday" class="Wdate" /></td>
	</tr>
	<tr>
		<td class="left">我的网站：</td>
		<td class="right"><input name="mysite" placeholder="把网店、微博等网址放到这儿，有机会我们会推荐的哦！" id="mysite" class="input_long" /></td>
	</tr>
	<tr>
		<td colspan="2" style="text-align: right;"><input type="submit" class="submit_but" id="submit" value="确定"></td>
	</tr>
</table>
</form>	
</div>
</div>
</body>
</html>