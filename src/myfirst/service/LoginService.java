/**  
 * @Title: UserService.java 
 * @Package myfirst.service 
 * @Description: TODO 
 * @author Rock King 2014年12月18日 上午12:34:17
 * @version V1.0  
 */
package myfirst.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import myfirst.base.BaseService;
import myfirst.dao.LoginDao;
import myfirst.domain.pojo.User;
import myfirst.utils.Base64Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @author Rock King 2014年12月18日 上午12:34:17
 * @see ~!^ Keep bugs away and code with U!
 */
@Service
// 将userService标注为一个服务层的bean
public class LoginService extends BaseService {

	@Autowired
	private LoginDao loginDao;

	public User findUserById(int id) {
		return loginDao.findUserById(id);
	}

	public void delete(User user) {
		loginDao.delete(user);
	}

	public void save(User user) {
		loginDao.save(user);
	}

	/**
	 * 对用户传过来的注册信息进行加密
	 * 
	 * @param user
	 * @return
	 */
	public String sendRegisterCheckInfoMail(User user) {
		loginDao.sendRegisterCheckInfoMail(user);
		return null;
	}
}
