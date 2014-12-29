package myfirst.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myfirst.dao.HomePageDao;
import myfirst.domain.vo.CrawlerVO;
import myfirst.utils.CookiesUtil;
import myfirst.utils.CrawlerUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomePageService {

	@Autowired
	private HomePageDao homePageDao;
	
	/**保存我的网站cookie
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 */
	public void doSaveCookies(HttpServletResponse response, String name, String value, int maxAge){
		CookiesUtil.addCookie(response, name, value, maxAge);
	}
	
	/**得到cookies保存的我的网站的信息
	 * @param request
	 * @return
	 */
	public List<Map<String, String>> getWebSiteByCookie(HttpServletRequest request){
		List<Map<String, String>> websiteListList = new ArrayList<Map<String,String>>();
		try {
			Cookie cookie = CookiesUtil.getCookieByCookieName(request, CookiesUtil.WEBSITECOOKIENAME);
			if(cookie != null){
				String siteInfoString = cookie.getValue();
				siteInfoString = URLDecoder.decode(siteInfoString, "UTF-8");	//因为可能有中文，转码
				String[] sites = siteInfoString.split("\\|");
				for(int i=0;i<sites.length && i<10;i=i+2){	//最多只能保存5个网址
					Map<String, String> siteMap = new HashMap<String, String>();
					siteMap.put("sitename", sites[i]);
					siteMap.put("siteurl", sites[i+1]);
					websiteListList.add(siteMap);
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return websiteListList;
	}
	
	/**从CrawlerUtil.crawlerVOs中随机取5条记录
	 * @see Any changes please send mail to:superman166@126.com  
	 * ~!^ Keep bugs away and code with U!	
	 */
	public List<CrawlerVO> getCrawlerVOList() {
		return homePageDao.getCrawlerVOList();
	}
}
