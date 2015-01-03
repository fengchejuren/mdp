/**  
 * @Title: UserDao.java 
 * @Package myfirst.dao 
 * @Description: TODO 
 * @author Rock King 2014年12月18日 上午12:01:29
 * @version V1.0  
 */ 
package myfirst.dao;

import myfirst.base.BaseDAO;
import myfirst.domain.pojo.User;

import org.springframework.stereotype.Repository;

/** 
 * @Description: TODO
 * @author Rock King 2014年12月18日 上午12:01:29 
 * @see ~!^ Keep bugs away and code with U!	 
 */
@Repository   //通过spring注解定义一个dao
public class LoginDao extends BaseDAO {


	public User findUserById(int id){
		User user = entityManager.find(User.class, id);
		return user;
	}
	
	public void delete(User user){
		entityManager.remove(user);
	}
}
