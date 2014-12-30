
	$(document).ready(function(){
		getwebsitebyCookie();	//根据cookies得到我的网址
		$("#refresh_news").click(function(){
			refreshnews();
		});
	});
	//根据cookies得到我的网址
	function getwebsitebyCookie(){
		var cookieObj = document.cookie.split("; ");
		var htmlStr = '';
		for(var i=0;i<cookieObj.length;i++){
			var arr = cookieObj[i].split("=");
			if("<%=CookiesUtil.WEBSITECOOKIENAME%>" == arr[0]){
				var now = new Date();
				now.setDate(now.getDate()+180);	//cookies过期日期为180天
				document.cookie = arr[0]+"="+arr[1]+";expires="+now.toGMTString();		//更新cookies 
				var cookieinfo = decodeURI(arr[1]).split("|");
				for(var i=0;i<cookieinfo.length;i=i+2){		
					htmlStr += '<li><a href="'+cookieinfo[i+1]+'" target="_blank">'+cookieinfo[i]+'</a></li>';	
				}
			}
			$("#mysite").append(htmlStr);
		}
	}	
	
	//刷新新闻
	function refreshnews(){
		$.ajax({
			type:"get",
			url:"${ctx}/homepage/getAjaxNews.html",
			dataType:"html",
			success:function(data){
				var result = eval("("+data+")");
				var htmlStr = '<ul class="homepage_news_list">';
				for(var i=0;i<result.length;i++){
					htmlStr += '<li style="float: none;"><a href="'+result[i].url+'" target="_blank">'+result[i].title+'</a><br></li>';
				}
				htmlStr +='</ul>';
				$("#news_content").html(htmlStr);
			}
		});
	}
