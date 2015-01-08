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
	/**注册时向用户的邮箱发送邮件进行验证
	 * @return
	 */
	@RequestMapping(value = "/registerCheck.html")
	public ModelAndView registerPage(User user){
		loginService.sendRegisterCheckInfoMail(user);
		return new ModelAndView("login/loadEmailPage")
						.addObject("user",user);
	}

	/**保存用户的注册信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/doAddRegisterInfo.html")
	public ModelAndView doAddRegisterInfo(HttpServletRequest request) throws Exception{
		String info = request.getParameter("info");
		logger.debug(info);
		User user = loginService.doAddRegisterInfo(info);
		if(user == null){
			throw new Exception();
		}
		request.getSession().setAttribute("user", user);
		return new ModelAndView("login/fillinginfo");
	}
	
	/**用户登录检查 
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
