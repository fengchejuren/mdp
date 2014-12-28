package myfirst.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myfirst.service.HomePageService;
import myfirst.utils.CookiesUtil;

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
	public ModelAndView index(HttpServletRequest request){
		List<Map<String, String>> cookieList = homePageService.getWebSiteByCookie(request);
		return new ModelAndView("homepage/homepage_index")
						.addObject("cookieList",cookieList);
	}
	
	/** 修改我的网址导航
	 * @return   
	 * @see Any changes please send mail to:superman166@126.com  
	 * ~!^ Keep bugs away and code with U!	
	 */
	@RequestMapping(value="/myfavoritewebsite.html")
	public ModelAndView domyfavoritewebsite(HttpServletRequest request){
		List<Map<String, String>> cookieList = homePageService.getWebSiteByCookie(request);
		return new ModelAndView("homepage/myfavoritewebsite")
					.addObject("cookieList",cookieList);
	}
	
	/** 保存我的网址cookies
	 * @return   
	 * @see Any changes please send mail to:superman166@126.com  
	 * ~!^ Keep bugs away and code with U!	
	 */
	@RequestMapping(value="/dosavewebsite.html")
	public ModelAndView dosavewebsite(HttpServletRequest request,HttpServletResponse response){
		String siteInfo = request.getParameter("siteInfo");
		homePageService.doSaveCookies(response, CookiesUtil.WEBSITECOOKIENAME, siteInfo, 365*60*60);
		return new ModelAndView(new RedirectView("index.html", true));
	}
}
