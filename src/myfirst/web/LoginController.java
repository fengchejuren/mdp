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
import javax.servlet.http.HttpSession;

import myfirst.base.BaseController;
import myfirst.domain.pojo.User;
import myfirst.exception.BusinessException;
import myfirst.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
	@RequestMapping(value = "/login.html")
	public String loginPage() {
		return "login/login_index";
	}
	
	/**注册对话框
	 * @return
	 */
	@RequestMapping(value = "/register.html")
	public String registerPage(){
		return "login/register";
	}
	
	/**注册时保存用户
	 * @return
	 */
	@RequestMapping(value = "/doregister.html")
	public ModelAndView registerPage(HttpSession session,User user){
		user.setRegisterTime(new Date());
		user.setLastVisitTime(new Date());
		session.setAttribute("user", user);
		userService.doSave(user);		//保存用户
		return new ModelAndView("login/success");
	}

	/**完善用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/fillingInfo.html")
	public ModelAndView doAddRegisterInfo(HttpServletRequest request,HttpSession session) throws Exception{
		User user = (User) session.getAttribute("user");	//登录者的user信息
		String info = request.getParameter("info");
		User user2 = userService.doAddRegisterInfo(info);	//验证链接传递过来的user信息
		if(!user.getUsername().equals(user2.getUsername()) || !user.getEmail().equals(user2.getEmail())){
			throw new BusinessException("登陆者的邮箱和验证邮箱不匹配！");
		}
		return new ModelAndView("login/fillinginfo");
	}
	
	
	/** 发送邮件进行邮箱验证
	 * returns:ModelAndView  
	 * @see any changes please send mail to:superman166@126.com  
	 * ~!^ keep bugs away and code of god with u!	
	 */
	@RequestMapping(value="/valid_email.html")
	public ModelAndView validEmail(HttpSession session){
		User user = (User) session.getAttribute("user");
		userService.sendRegisterCheckInfoMail(user);
		return new ModelAndView("login/send_email_ok");
	}
	
	/**用户登录
	 * @see any changes please send mail to:superman166@126.com  
	 * ~!^ keep bugs away and code of god with u!	
	 */
	@RequestMapping(value = "/logincheck.html")
	public ModelAndView loginCheck(HttpServletRequest request,
			User user,HttpSession session) {
		String username = user.getUsername();
		String password = user.getPassword();
		List<User> list = userService.findByUsername(username);
		User user2 = list.get(0);
		if(password.equals(user2.getPassword())){
			session.setAttribute("user", user2);
			return new ModelAndView(new RedirectView("../homepage/index.html"));
		}
		//loginService.delete(user2);
		return null;
	}
	
	@RequestMapping(value="/loginOut.html")
	public ModelAndView loginOut(HttpSession session){
		session.removeAttribute("user");
		return new ModelAndView(new RedirectView("../homepage/index.html"));
	}
	
	
}
