<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/head.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源共享</title>
<link rel="stylesheet" href="${ctx}/css/main.css">
<script src="${ctx}/js/jquery_2.1.3.js"></script>
<script src="${ctx}/js/common.js"></script>
</head>
<body>
<%@include file="../include/ad.jsp" %>
<!--下面是主要内容-->
<div class="content">
<!-- 导航栏 -->
<%@include file="../include/navigationbar.jsp" %>
 <div class="filecontent">
 <form action="${ctx}/file/filelistup.html" method="post" enctype="multipart/form-data">
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
 			<input type="file" name="file1" /> <input type="text" name="alais" /><br />  
		    <input type="file" name="file2" /> <input type="text" name="alais" /><br />  
		    <input type="file" name="file3" /> <input type="text" name="alais" /><br />  
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