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

	@RequestMapping(value = "/logincheck.html")
	public ModelAndView loginCheck(HttpServletRequest request,
			LoginCommand loginCommand) {
		boolean isvalideUser = loginService.hasMatchUser(
				loginCommand.getUserName(), loginCommand.getPassword());
		if (!isvalideUser)
			return new ModelAndView("login", "error", "用户名或密码错误");
		else {
			User user = loginService.findUserByUserName(loginCommand
					.getUserName());
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}

	}
}
