<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="inc/head.inc" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>这个是一个登录测试</title>
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
        二. CSS居中 — 垂直居中

1． 如何使图片在DIV 中垂直居中
对这个CSS居中问题，我们可以使用设置背景图片的方法。举例：
body {BACKGROUND: url(”sample.gif”) #FFF no-repeat center;}
关键就在于这个Center属性，它表示让该背景图片在容器中居中。你也可以把Cener换成Top Left或者直接写上数字来调整它的位置。
<img src="${ctx}/images/ad/assistant.jpg" class="assistant" style="width:20px;height:15px;"/>
一、CSS 居中 — 水平居中

DIV等标签本身没有定义自己居中的属性，网上很多的方法都是介绍用上级的text-align: center，然后嵌套一层DIV来解决问题。
可是这个方法有时候完全不起作用，而且对于布局是非常不科学的方法。正确的的设置写法如下（对页面构造没有影响）：
div {margin-left: auto; margin-right: auto; }
这句CSS居中的意思就是让div自己调整左右margin间隔的距离以达到水平居中的效果。
有时候我们还可以简写为 div { margin:0px auto; }
但这样的简写法，如果你调整 margin-top 或者 margin-bottom 就会失去CSS居中的水平居中效果。
另外，如果你的div还没有指定宽度（可以是相对的大小），这种CSS居中写法也起不到应有的效果，解决办法是为这个div指定一个width宽度，例如： width:auto; 或者 width:50% 之类的。
同时，你的页面类型即document type必须声明为xhtml。至于松散还是严格都不影响。
这个写法也适用于图片img和一些其他的盒状标签的CSS居中。
最后，假如你在IE和FireFox两个浏览器中看起来不一样，你最好采用 text-align:center; 和 margin 两个CSS居中一起设置的方法。例如：
#layout  {TEXT-ALIGN: center;}
#center { MARGIN-RIGHT: auto; MARGIN-LEFT: auto; }
说明：首先在父级元素定义TEXT-ALIGN: center;这个的意思就是在父级元素内的内容居中；对于IE这样设定就已经可以了。但在mozilla中不能居中。解决办法就是在子元素定义时候设定 时再加上“MARGIN-RIGHT: auto;MARGIN-LEFT: auto; ”需要说明的是，如果你想用这个方法使整个页面要居中，建议不要套在一个DIV里，你可以依次拆出多个div，只要在每个拆出的div里定义MARGIN -RIGHT: auto;MARGIN-LEFT: auto; 就可以了。    二. CSS居中 — 垂直居中
先在父级元素定义TEXT-ALIGN: center;这个的意思就是在父级元素内的内容居中；对于IE这样设定就已经可以了。但在mozilla中不能居中。解决办法就是在子元素定义时候设定 时再加上“MARGIN-RIGHT: auto;MARGIN-LEFT: auto; ”需要说明的是，如果你想用这个方法使整个页面要居中，建议不要套在一个DIV里，你可以依次拆出多个div，只要在每个拆出的div里定义MARGIN -RIGHT: auto;MARGIN-LEFT: auto; 就可以了。
</div>
</body>
</html>