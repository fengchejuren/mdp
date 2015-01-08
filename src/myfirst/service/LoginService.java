/**  
 * @Title: UserService.java 
 * @Package myfirst.service 
 * @Description: TODO 
 * @author Rock King 2014年12月18日 上午12:34:17
 * @version V1.0  
 */
package myfirst.service;

import java.util.Date;

import myfirst.base.BaseService;
import myfirst.dao.LoginDao;
import myfirst.domain.pojo.User;
import myfirst.utils.ConstantUtil;

import org.apache.tomcat.util.codec.binary.Base64;
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
	 * 对用户传过来的注册信息进行Base64编码,并发送验证邮件
	 * 
	 * @param user
	 * @return
	 */
	public void sendRegisterCheckInfoMail(User user) {
		loginDao.sendRegisterCheckInfoMail(user);
	}

	/**解析用户获取的信息传递过来的链接信息，并将注册信息保存进数据库
	 * 操作成功，返回0，失败返回1
	 * @param info
	 */
	public User doAddRegisterInfo(String info) {
			byte[] bytes = Base64.decodeBase64(info);
			User user = null;
			String str = new String(bytes);
			String[] strInfo = str.split("\\|");
			long now = new  Date().getTime();
			if(strInfo.length!=4 || now-Long.valueOf(strInfo[3])>ConstantUtil.DIVIDED_TIME)
				logger.debug("此链接已经过期或者不是正常的链接，你可以用相同的邮箱重新注册！");;
//				throw new BusinessException("此链接已经过期或者不是正常的链接，你可以用相同的邮箱重新注册！");
			user = new User();
			user.setUsername(strInfo[0]);
			user.setPassword(strInfo[1]);
			user.setEmail(strInfo[2]);
			user.setRegisterTime(new Date());
			//TODO 此处进行写入数据库的保存操作
			return user;
	}
}
