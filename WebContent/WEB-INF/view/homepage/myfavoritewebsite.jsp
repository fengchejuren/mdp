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
.myfavoritewebsite input {
	margin:5px;
}
.myfavoritewebsite .siteurl {
	width:280px;
}
</style>
<script src="${ctx}/js/jquery_2.1.3.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".submit_but").click(function(){
			dosubmit();
		});
		$(".add").click(function(){
			addItem(this);
		});
		$(".delete").click(function(){
			deleteItem(this);
		});
		
		var cookieObj = document.cookie;
	});
	
	//增加网址
	function addItem(obj){
		var listObj = $(".websiteItem");
		if(listObj.length>=5){
			alert("用户最多只能保存5个网址");
		}else{
			var htmlStr = '<div class="websiteItem">网站名称：<input '
					+'name="sitename" class="sitename" maxlength="8" />'
					+'网站地址：<input name="siteurl" class="siteurl" maxlength="50"/>'
					+'<img title="增加" class="btn_after_input add" '
					+'src="${ctx}/images/btn/add_icon.png" alt="增加" onclick="addItem(this)"/></div>';
			var addbtnStr = '<img title="删除" class="btn_after_input delete" onclick="deleteItem(this);"'
							+'src="${ctx}/images/btn/close_icon.png" alt="删除"/>';
			$(obj).parent().after(htmlStr);
			$(obj).replaceWith(addbtnStr);
		}
	}
	
	//删除网址
	function deleteItem(obj){
		$(obj).parent().remove();
	}
	
	//提交数据到后台
	function dosubmit(){
		var obj = $(".websiteItem").children(":input");
		var flag = true;
		var data = "";
		for(var i=0;i<obj.length;i++){
			data += obj[i].value + "|";
			if(!obj[i].value){
				$(obj[i]).css("border","1px solid red");
				flag = false;
			}
		}
		if(!flag){
			return false;
		}else{
			data = data.substring(0,data.length-1);
			$("#siteInfo").val(data);
			window.location.href="${ctx}/homepage/dosavewebsite.html?siteInfo="+data;
		}
		
	}
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
<input type="hidden" id="siteInfo" name="siteInfo"/>
<c:forEach items="${cookieList}" var="item" varStatus="count">
	<div class="websiteItem">
		网站名称：<input value="${item.sitename}" name="sitename" class="sitename" maxlength="8" />网站地址：<input name="siteurl" value="${item.siteurl}" class="siteurl" maxlength="50"/>
	<c:choose>
		<c:when test="${not count.last}">
			<img title="删除" class="btn_after_input delete" src="${ctx}/images/btn/close_icon.png" alt="删除"/>
		</c:when>
		<c:otherwise>
			<img title="增加" class="btn_after_input add" src="${ctx}/images/btn/add_icon.png" alt="增加"/>
		</c:otherwise>
	</c:choose>	
	</div>
</c:forEach>
	<input type="button" class="submit_but" value="保 存" />
	<div style="clear:both;"></div>
</div>
</div>
</body>
</html>