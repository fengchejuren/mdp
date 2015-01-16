package mdp;

import myfirst.domain.pojo.User;
import myfirst.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/config/applicationContext.xml"})
public class TestJPA {

	@Autowired
	private UserService userService;
	
	@Test
	public void testUserService(){
		User user = new User();
		user.setId(12);
		user.setUsername("小x风o");
		user.setPassword("xiaoferengfeng");
		user.setEmail("xiae00ng@fsder.com");
		userService.doSave(user);
		//userService.doDelete(14);
		//User user2 = userService.findById(4);
		//System.out.println(user2.getEmail());
		//userService.deleteById(5);
	}
}
