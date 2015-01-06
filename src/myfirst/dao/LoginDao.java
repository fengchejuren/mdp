/**  
 * @Title: UserDao.java 
 * @Package myfirst.dao 
 * @Description: TODO 
 * @author Rock King 2014年12月18日 上午12:01:29
 * @version V1.0  
 */
package myfirst.dao;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import myfirst.base.BaseDAO;
import myfirst.domain.pojo.User;
import myfirst.utils.Base64Util;
import myfirst.utils.MailUtil;

import org.springframework.stereotype.Repository;

/**
 * @Description: TODO
 * @author Rock King 2014年12月18日 上午12:01:29
 * @see ~!^ Keep bugs away and code with U!
 */
@Repository
// 通过spring注解定义一个dao,与Service的区别是对异常的封装
public class LoginDao extends BaseDAO {

	public User findUserById(int id) {
		User user = entityManager.find(User.class, id);
		return user;
	}

	public void delete(User user) {
		entityManager.remove(entityManager.getReference(User.class,
				user.getId()));
	}

	/**
	 * 用户注册时发送信息到用户的邮箱进行验证
	 * 
	 * @param user
	 */
	public void sendRegisterCheckInfoMail(User user) {
		String string = user.getUsername() + "|" + user.getPassword() + "|"
				+ user.getEmail() + "|" + new Date().getTime();
		logger.debug("未加密的字符串：---------------------------" + string);
		String s = Base64Util.encode(string.getBytes());
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html><body>");
		buffer.append("尊敬的");
		buffer.append(user.getUsername());
		buffer.append(":<br>&nbsp; 亲，是你吗，是你在<a href='http://localhost:8080/mdp/homepage/index.html' target='_top' style='text-decoration: NONE;'>我的地盘</a>网站上用此邮箱注册了账号吗？猛戳<a href='http://localhost:8080/mdp/login/doAddRegisterInfo.html?info=");
		buffer.append(s);
		buffer.append("' target='_top' style='text-decoration: NONE;'>这儿</a>，完成注册。或者将下面的网址复制到地址栏中完成注册。<br>&nbsp;&nbsp;http://localhost:8080/mdp/login/doAddRegisterInfo.html?info=");
		buffer.append(s);
		buffer.append("为了你的账户安全，请在10分钟之内完成此操作。<div style='width:100%;border-bottom:1px solid #ccc;margin:10px 0;'>&nbsp;&nbsp;如果不是你本人操作，那么就忽略它吧！当然，也请你注意自己个人信息的保密，必要时请修改邮箱密码！");
		buffer.append("</body></html");
		MailUtil.sendMail(user.getEmail(), "这是来自我的地盘网站的注册验证邮件", buffer.toString());
	}
}
