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
	
	@RequestMapping(value="/index.html")
	public ModelAndView index(HttpServletRequest request){
		List<Map<String, String>> cookieList = homePageService.getWebSiteByCookie(request);
		return new ModelAndView("homepage/homepage_index")
						.addObject("cookieList",cookieList);
	}
	
	@RequestMapping(value="/myfavoritewebsite.html")
	public String domyfavoritewebsite(){
		return "homepage/myfavoritewebsite";
	}
	
	@RequestMapping(value="/dosavewebsite.html")
	public ModelAndView dosavewebsite(HttpServletRequest request,HttpServletResponse response){
		String sitename = request.getParameter("sitename");
		String siteurl = request.getParameter("siteurl");
		homePageService.doSaveCookies(response, CookiesUtil.WEBSITECOOKIENAME, sitename+"|"+siteurl, 365*60*60);
		return new ModelAndView(new RedirectView("index.html", true));
	}
}
