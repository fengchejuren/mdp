package myfirst.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**操作Cookies
 * @author Administrator
 *
 */
public class CookiesUtil {

	/**
	 * 保存我的网站时储存的cookies名称
	 */
	public static final String WEBSITECOOKIENAME = "siteinfocookie";

	/**新增一个cookie
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 */
	public static void addCookie(HttpServletResponse response,String name,String value,int maxAge){
		Cookie cookie = new Cookie(name, value);
		if(maxAge>0){
			cookie.setMaxAge(maxAge);
		}
		response.addCookie(cookie);
	}
	
	/**通过cookieName得到Cookie
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static Cookie getCookieByCookieName(HttpServletRequest request,String cookieName){
		Map<String, Cookie> cookieMap = readCookieMap(request);
		Cookie cookie = null;
		if(cookieMap.containsKey(cookieName)){
			cookie = cookieMap.get(cookieName);
		}
		return cookie;
		
	}
	
	/**读取所有的cookie
	 * @param request
	 * @return
	 */
	public static Map<String, Cookie> readCookieMap(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		if(cookies != null){
			for(Cookie cookie:cookies){
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}
}
