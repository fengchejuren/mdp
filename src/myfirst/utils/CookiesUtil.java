package myfirst.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

	/**新增一个cookie
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 */
	public static void addCookie(HttpServletResponse response,String name,String value,int maxAge){
		try {
//			因为可能有中文，进行转码
			value = URLEncoder.encode(value, "UTF-8");
			Cookie cookie = new Cookie(name, value);
			if(maxAge>0){
				cookie.setMaxAge(maxAge);
			}
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
