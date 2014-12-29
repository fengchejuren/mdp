package myfirst.web;

import java.util.List;

import myfirst.domain.vo.CrawlerVO;
import myfirst.service.HomePageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/homepage")
public class HomePageController {

	@Autowired
	private HomePageService homePageService;
	
	/** 跳转到我的主页（页面上操作cookies,如果cookies上保存有我的网站的信息，则将信息加载进去）
	 * @param request
	 * @return   
	 * @see Any changes please send mail to:superman166@126.com  
	 * ~!^ Keep bugs away and code with U!	
	 */
	@RequestMapping(value="/index.html")
	public ModelAndView index(){
		HomePageService service = new HomePageService();
		List<CrawlerVO> crawlerVOList = service.getCrawlerVOs();
		return new ModelAndView("homepage/homepage_index")
						.addObject("crawlerVOList",crawlerVOList);
	}
	
	/** 修改我的网址导航
	 * @return   
	 * @see Any changes please send mail to:superman166@126.com  
	 * ~!^ Keep bugs away and code with U!	
	 */
	@RequestMapping(value="/myfavoritewebsite.html")
	public String domyfavoritewebsite(){
		return "homepage/myfavoritewebsite";
	}

}
