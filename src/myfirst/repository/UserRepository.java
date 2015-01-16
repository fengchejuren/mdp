package myfirst.repository;

import java.util.List;

import myfirst.base.BaseRepository;
import myfirst.domain.pojo.User;

public interface UserRepository extends BaseRepository<User, Integer>{


	/**通过用户名查找用户
	 * @param username
	 * @return
	 */
	public List<User> findByUsername(String username);
	
	/**通过邮箱查找用户
	 * @param email
	 * @return
	 */
	public List<User> findByEmail(String email);
	
	
	
	
	
}
