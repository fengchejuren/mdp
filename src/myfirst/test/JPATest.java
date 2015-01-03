
/**  
	* @author Rock King 2015年1月1日 下午7:10:10
	* @version V1.0  
*/ 
 
package myfirst.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import myfirst.domain.pojo.User;

import org.junit.Test;


 		/** 
 * @author Rock King 2015年1月1日 下午7:10:10 
 * @see ~!^ keep bugs away and code of god with u!	 
 */

public class JPATest {

	private EntityManagerFactory factory;
	
	public JPATest(){
		factory = Persistence.createEntityManagerFactory("myJPA");
	}
	
	@Test
	public void testJPA(){
		factory = Persistence.createEntityManagerFactory("myJPA");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		User user = manager.find(User.class, 1);
		System.out.println(user.getUsername());
	}
}
