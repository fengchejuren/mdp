<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="width:100%;background:#20501e;height:30px;vertical-align: middle;line-height:30px;font-size:12px;padding:0 20px;">
<c:if test="${empty user}">
欢迎光临我的地盘！
<a href="${ctx}/login/login.html">登录</a>&nbsp;&nbsp;
<a href="${ctx}/login/register.html">注册</a>
</c:if>
<c:if test="${not empty user}">
尊敬的${user.username},欢迎光临我的地盘！上次登录时间是
<fmt:formatDate value="${user.lastVisitTime}" pattern="yyyy年MM月dd日  HH:mm:ss"/>
<a href="${ctx}/login/loginOut.html">退出</a>
</c:if>
</div>
<!-- 导航栏  -->
<div class="navigation_bar">
<ul>
	<li><a href="${ctx}/homepage/index.html">我的主页</a></li>
	<li><a>快乐驿站</a></li>
	<li><a>历史上的今天</a></li>
	<li><a>我的咖啡屋</a></li>
	<li><a href="${ctx}/file/index.html">资源共享</a></li>
	<li><a>生活助手</a></li>
</ul>
<div style="clear:both;"></div>
</div>