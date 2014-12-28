package myfirst.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myfirst.service.HomePageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/homepage")
public class HomePageController {

	@Autowired
	private HomePageService homePageService;
	
	/** 跳转到我的主页（如果cookies上保存有我的网站的信息，则将信息加载进去）
	 * @param request
	 * @return   
	 * @see Any changes please send mail to:superman166@126.com  
	 * ~!^ Keep bugs away and code with U!	
	 */
	@RequestMapping(value="/index.html")
	public String index(HttpServletRequest request){
		return "homepage/homepage_index";
	}
	
	/** 修改我的网址导航
	 * @return   
	 * @see Any changes please send mail to:superman166@126.com  
	 * ~!^ Keep bugs away and code with U!	
	 */
	@RequestMapping(value="/myfavoritewebsite.html")
	public String domyfavoritewebsite(HttpServletRequest request){
		return "homepage/myfavoritewebsite";
	}

}
