package myfirst.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myfirst.utils.CookiesUtil;

import org.springframework.stereotype.Service;

@Service
public class HomePageService {

	/**保存我的网站cookie
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 */
	public void doSaveCookies(HttpServletResponse response, String name, String value, int maxAge){
		CookiesUtil.addCookie(response, name, value, maxAge);
	}
	
	/**得到我的网站的信息
	 * @param request
	 * @return
	 */
	public List<Map<String, String>> getWebSiteByCookie(HttpServletRequest request){
		List<Map<String, String>> resultList = new ArrayList<Map<String,String>>();
		Cookie cookie = CookiesUtil.getCookieByCookieName(request, CookiesUtil.WEBSITECOOKIENAME);
		if(cookie != null){
			String siteInfoString = cookie.getValue();
			String[] sites = siteInfoString.split("\\|");
			for(int i=0;i<sites.length;i++){
				
			}
		}
		return resultList;
	}
}
