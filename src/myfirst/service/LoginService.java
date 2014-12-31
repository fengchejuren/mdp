/**  
 * @Title: UserService.java 
 * @Package myfirst.service 
 * @Description: TODO 
 * @author Rock King 2014年12月18日 上午12:34:17
 * @version V1.0  
 */ 
package myfirst.service;

import myfirst.base.BaseService;
import myfirst.dao.UserDao;
import myfirst.domain.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 
 * @Description: TODO
 * @author Rock King 2014年12月18日 上午12:34:17 
 * @see ~!^ Keep bugs away and code with U!	 
 */
@Service   //将userService标注为一个服务层的bean
public class LoginService extends BaseService {

	@Autowired
	private UserDao userDao;
	
	public boolean hasMatchUser(String userName,String password){
		return userDao.getMatchCount(userName, password)>0;
	}
	
	public User findUserByUserName(String userName){
		return userDao.findUserByUserName(userName);
	}
}