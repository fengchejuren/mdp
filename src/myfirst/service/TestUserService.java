/**  
 * @Title: TestUserService.java 
 * @Package mdp 
 * @Description: TODO 
 * @author Rock King 2014年12月18日 下午9:49:01
 * @version V1.0  
 */ 
package myfirst.service;

import myfirst.base.BaseService;
import myfirst.domain.pojo.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * @Description: TODO
 * @author Rock King 2014年12月18日 下午9:49:01 
 * @see ~!^ Keep bugs away and code with U!	 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/config/applicationContext.xml"})
public class TestUserService extends BaseService {

	@Autowired
	private LoginService userService;
	
//	@Test
//	public void hasMatchUser() {
//		boolean b1 = userService.hasMatchUser("xiaoming", "xiao");
//		boolean b2 = userService.hasMatchUser("xiaoming", "xiaoM");
//		System.out.println(b2);
//	}

	@Test
	public void findUserByName(){
		User user = userService.findUserById(4);
		System.out.println(user.getUsername()+"  "+user.getId()+"-----------------------------------------------------");
	}
	
	@Test
	public void testDelete(){
		User user = new User();
		user.setId(4);
		logger.debug("开始执行删除操作。。。。。。。。。。。。。。。。。。。。。。。");
		userService.delete(user);
	}
}
