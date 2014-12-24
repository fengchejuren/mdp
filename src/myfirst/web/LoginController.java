/**  
 * @Title: LoginController.java 
 * @Package myfirst.web 
 * @Description: TODO 
 * @author Rock King 2014年12月18日 上午1:19:07
 * @version V1.0  
 */
package myfirst.web;

import javax.servlet.http.HttpServletRequest;

import myfirst.domain.User;
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
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/index.html")
	public String loginPage() {
		return "index";
	}

	@RequestMapping(value = "/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request,
			LoginCommand loginCommand) {
		boolean isvalideUser = userService.hasMatchUser(
				loginCommand.getUserName(), loginCommand.getPassword());
		if (!isvalideUser)
			return new ModelAndView("login", "error", "用户名或密码错误");
		else {
			User user = userService.findUserByUserName(loginCommand
					.getUserName());
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}

	}
}
