package myfirst.service;

import java.util.Date;
import java.util.List;

import myfirst.base.BaseService;
import myfirst.domain.pojo.User;
import myfirst.exception.BusinessException;
import myfirst.repository.UserRepository;
import myfirst.utils.ConstantUtil;
import myfirst.utils.MailUtil;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService extends BaseService<User, Integer> {

	@Autowired
	private UserRepository userRepository;
	/**解析用户获取的信息传递过来的链接信息，并将注册信息保存进数据库
	 * 操作成功，返回0，失败返回1
	 * @param info
	 */
	public User doAddRegisterInfo(String info) throws Exception{
			byte[] bytes = Base64.decodeBase64(info);
			User user = null;
			String str = new String(bytes);
			String[] strInfo = str.split("\\|");
			long now = new  Date().getTime();
			if(strInfo.length!=4){
				throw new BusinessException("此链接为非法链接！");
			}else if(now-Long.valueOf(strInfo[3])>ConstantUtil.DIVIDED_TIME){
				throw new BusinessException("此链接已经过期，请您重新操作！");
			}
			user = new User();
			user.setUsername(strInfo[0]);
			user.setPassword(strInfo[1]);
			user.setEmail(strInfo[2]);
			user.setRegisterTime(new Date());
			return user;
	}

	/**
	 * 对用户传过来的注册信息进行Base64编码,并发送验证邮件
	 * 
	 * @param user
	 */
	public void sendRegisterCheckInfoMail(User user) {
		String string = user.getUsername() + "|" + user.getPassword() + "|"
				+ user.getEmail() + "|" + new Date().getTime();
		//logger.debug("未加密的字符串：---------------------------" + string);
		byte[] bytes = Base64.encodeBase64(string.getBytes());
		String s = new String(bytes);
		StringBuffer buffer = new StringBuffer();
		buffer.append("<html><body>");
		buffer.append("尊敬的");
		buffer.append(user.getUsername());
		buffer.append(":<br>&nbsp; 亲，是你吗，是你在<a href='http://localhost:8080/mdp/homepage/index.html' target='_top' style='text-decoration: NONE;'>我的地盘</a>网站上用此邮箱注册了账号吗？猛戳<a href='http://localhost:8080/mdp/login/fillingInfo.html?info=");
		buffer.append(s);
		buffer.append("' target='_top' style='text-decoration: NONE;'>这儿</a>，或者将下面的网址复制到地址栏中直接访问，完成注册。为了你的账户安全，本链接仅在10分钟之内有效。小伙伴，赶快飞起来去抢我的地盘吧！<br>&nbsp;&nbsp;http://localhost:8080/mdp/login/fillingInfo.html?info=");
		buffer.append(s);
		buffer.append("<div style='width:100%;border-bottom:1px solid #ccc;margin:10px 0;'>&nbsp;&nbsp;如果不是你本人操作，那么就忽略它吧！当然，也请你注意自己个人信息的保密，必要时请修改邮箱密码！");
		buffer.append("</body></html");
		MailUtil.sendMail(user.getEmail(), "这是来自我的地盘网站的注册验证邮件", buffer.toString());
	}
	
	/**通过用户名查找用户
	 * @param username
	 * @return
	 */
	public List<User> findByUsername(String username){
		return userRepository.findByUsername(username);
	}
	
	/**通过邮箱查找用户
	 * @param email
	 * @return
	 */
	public List<User> findByEmail(String email){
		return userRepository.findByEmail(email);
	}
}
