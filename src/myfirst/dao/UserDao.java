/**  
 * @Title: UserDao.java 
 * @Package myfirst.dao 
 * @Description: TODO 
 * @author Rock King 2014年12月18日 上午12:01:29
 * @version V1.0  
 */ 
package myfirst.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import myfirst.domain.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

/** 
 * @Description: TODO
 * @author Rock King 2014年12月18日 上午12:01:29 
 * @see ~!^ Keep bugs away and code with U!	 
 */
@Repository   //通过spring注解定义一个dao
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getMatchCount(String userName,String pwd){
		String sql = "select count(*) from t_user where user_name = ? and user_pwd = ?";
		return jdbcTemplate.queryForInt(sql,new Object[]{userName,pwd});
	}
	
	public User findUserByUserName(final String userName){
		String sql = "select id,user_name,credits from t_user where user_name = ?";
		final User user = new User();
		jdbcTemplate.query(sql, new Object[]{userName},
				new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setCredits(rs.getInt("credits"));
				user.setId(rs.getInt("id"));
				user.setUserName(userName);
			}
		});
		return user;
	}
}
