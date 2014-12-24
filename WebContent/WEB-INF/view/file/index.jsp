<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../inc/head.inc" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源下载</title>
<link rel="stylesheet" href="${ctx}/css/main.css">
 <script src="${ctx}/js/jquery_2.1.3.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".sidebar_content").click(function(){
				window.open("js1.html");	
		});
		$(".sidebar_close_icon").click(function(){
			$(this).parent().remove();	
		});
		$(".assistant").mouseover(function(e){
			$(this).after('<div style="background:#ccc;position:absolute;left:'+(e.pageX-130)+'px;right:'+(e.pageY-210)+'px;" id="assistantContent"><ul><li>查快递</li><li>查违章</li><li>查手机号码</li><li>查IP地址</li></ul></div>');
		});
		$(".assistant").mouseout(function(){
			//$("#assistantContent").remove();
		});
	});
		
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
 <div class="filecontent">
 <form action="${ctx}/file/fileup.html" method="post" enctype="multipart/form-data">
 <table>
 	<tr>
 		<td class="left">资源类型</td>
 		<td class="right">
 		<select name="filetype">
 			<option>spring MVC</option>
 			<option>struts2</option>
 			<option>js</option>
 			<option>html5</option>
 		</select>
 		</td>
 	</tr>
 	<tr>
 		<td class="left">资源说明</td>
 		<td class="right">
 			<textarea name="filedesc" rows="3" cols="20" maxlength="50"></textarea>
 		</td>
 	</tr>
 	<tr>
 		<td class="left">选择资源</td>
 		<td class="right">
 			<input type="file" name="myfile" />
 		</td>
 	</tr>
 	<tr>
 		<td colspan="2"><input type="submit" value="提交"></td>
 	</tr>
 </table>
 </form>
 </div>  
</div>
</body>
</html>