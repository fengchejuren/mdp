<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page language="java" import="myfirst.utils.CookiesUtil" %>
<%@include file="../include/head.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的主页</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/main.css">
<script src="${ctx}/js/jquery_2.1.3.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$(".submit_but").click(function(){
			dosubmit();
		});
		$(".add").click(function(){
			addItem(this);
		});
		//根据cookies得到我的网址
		getwebsitebyCookie();
	});
	//根据cookies得到我的网址
	function getwebsitebyCookie(){
		var cookieObj = document.cookie.split("; ");
		var htmlStr = '';
		for(var i=0;i<cookieObj.length;i++){
			var arr = cookieObj[i].split("=");
			if("<%=CookiesUtil.WEBSITECOOKIENAME%>" == arr[0]){
				var cookieinfo = decodeURI(arr[1]).split("|");
				for(var i=0;i<cookieinfo.length;i=i+2){		
					htmlStr += '<div class="websiteItem">网站名称：<input name="sitename" value="'+cookieinfo[i]+'" class="sitename" '
						+'maxlength="8" />网站地址：<input name="siteurl" value="'+cookieinfo[i+1]+'" '
						+'class="siteurl" maxlength="50"/>';
					if(i>=cookieinfo.length-2){	//最后一条记录，后面是增加按钮
						htmlStr += '<img title="增加" class="btn_after_input add" src="${ctx}/images/btn/add_icon.png" alt="增加" onclick="addItem(this)"/></div>';
					}else{	//不是最后一条记录，后面是删除按钮
						htmlStr += '<img title="删除" class="btn_after_input delete" onclick="deleteItem(this);"'
							+'src="${ctx}/images/btn/close_icon.png" alt="删除"/></div>';
					}	
				}
				
			}
			if(!htmlStr){	//htmlStr为空，即没有记录,增加一个空的input输入框
				htmlStr = '<div class="websiteItem">网站名称：<input name="sitename" class="sitename" '
							+'maxlength="8" />网站地址：<input name="siteurl" class="siteurl" maxlength="50"/>'
							+'<img title="增加" class="btn_after_input add" src="${ctx}/images/btn/add_icon.png" alt="增加" onclick="addItem(this)"/></div>';
			}
			$(".myfavoritewebsite").prepend(htmlStr);
		}
	}
	//增加cookie
	function addCookie(data){
		data = encodeURI(data);
		var now = new Date();
		now.setDate(now.getDate()+180);	//cookies过期日期为180天
		var str = "<%=CookiesUtil.WEBSITECOOKIENAME%>="+data+";expires="+now.toGMTString();
		document.cookie = str;
	}
	//增加网址输入框
	function addItem(obj){
		var listObj = $(".websiteItem");
		if(listObj.length>=5){		//最多只能保存5条记录
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
			addCookie(data);
			window.location.href="${ctx}/homepage/index.html";
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
	<input type="button" class="submit_but" value="保 存" />
	<div style="clear:both;"></div>
</div>
</div>
</body>
</html>