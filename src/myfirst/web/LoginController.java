/**  
 * @Title: LoginController.java 
 * @Package myfirst.web 
 * @Description: TODO 
 * @author Rock King 2014年12月18日 上午1:19:07
 * @version V1.0  
 */
package myfirst.web;

import javax.servlet.http.HttpServletRequest;

import myfirst.base.BaseController;
import myfirst.domain.pojo.User;
import myfirst.domain.vo.LoginCommand;
import myfirst.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: TODO
 * @author Rock King 2014年12月18日 上午1:19:07
 * @see ~!^ Keep bugs away and code with U!
 */
@Controller
@RequestMapping(value="/login")
public class LoginController extends BaseController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/index.html")
	public String loginPage() {
		return "login/login_index";
	}

	/**用户登录检查 
	 * returns:ModelAndView  
	 * @see any changes please send mail to:superman166@126.com  
	 * ~!^ keep bugs away and code of god with u!	
	 */
	@RequestMapping(value = "/logincheck.html")
	public ModelAndView loginCheck(HttpServletRequest request,
			User user) {
		User user2 = loginService.findUserById(2);
		User user3 = new User();
		user3.setUsername("明明");
		user3.setPassword("1234");
		user3.setEmail("32k@dfd.sdf");
		user2.setEmail("hello@124.com");
		loginService.save(user2);
		//loginService.delete(user2);
		return null;
	}
}
