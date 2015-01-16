/**  
 * @Title: LoginController.java 
 * @Package myfirst.web 
 * @Description: TODO 
 * @author Rock King 2014年12月18日 上午1:19:07
 * @version V1.0  
 */
package myfirst.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import myfirst.base.BaseController;
import myfirst.domain.pojo.User;
import myfirst.service.UserService;

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
	private UserService userService;

	/**登陆主页
	 * @return
	 */
	@RequestMapping(value = "/index.html")
	public String loginPage() {
		return "login/login_index";
	}
	
	/**注册页
	 * @return
	 */
	@RequestMapping(value = "/register.html")
	public String registerPage(){
		return "login/register";
	}
	
	/**保存用户
	 * @return
	 */
	@RequestMapping(value = "/doregister.html")
	public ModelAndView registerPage(User user){
		user.setRegisterTime(new Date());
		//userService.doSave(user);
		return new ModelAndView("login/success");
	}

	/**保存用户的注册信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/doAddRegisterInfo.html")
	public ModelAndView doAddRegisterInfo(HttpServletRequest request) throws Exception{
		String info = request.getParameter("info");
		logger.debug(info);
		User user = userService.doAddRegisterInfo(info);
		if(user == null){
			throw new Exception();
		}
		request.getSession().setAttribute("user", user);
		return new ModelAndView("login/fillinginfo");
	}
	
	/**用户登录
	 * @see any changes please send mail to:superman166@126.com  
	 * ~!^ keep bugs away and code of god with u!	
	 */
	@RequestMapping(value = "/logincheck.html")
	public ModelAndView loginCheck(HttpServletRequest request,
			User user) {
		String username = user.getUsername();
		List<User> list = userService.findByUsername(username);
		//loginService.delete(user2);
		return null;
	}
}
