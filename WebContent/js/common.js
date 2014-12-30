/**
 *此js文件存储通用的js方法 
 **/

	$(document).ready(function(){
		$(".sidebar_content").click(function(){
				window.open("js1.html");	
		});
		$(".sidebar_close_icon").click(function(){
			$(this).parent().remove();	
		});
	});
		

	$(".assistant").mouseover(function(e){
		$(this).after('<div style="background:#ccc;position:absolute;left:'+(e.pageX-130)+'px;right:'+(e.pageY-210)+'px;" id="assistantContent"><ul><li>查快递</li><li>查违章</li><li>查手机号码</li><li>查IP地址</li></ul></div>');
	});
	$(".assistant").mouseout(function(){
		//$("#assistantContent").remove();
	});
