/**  
 * @Title: AppUtils.java 
 * @Package myfirst 
 * @Description: TODO 
 * @author Rock King 2014年12月23日 上午12:48:25
 * @version V1.0  
 */ 
package myfirst.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

/** 
 * @Description: TODO
 * @author Rock King 2014年12月23日 上午12:48:25 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class AppUtils {

	private JdbcTemplate jdbcTemplate;
	public String getWeatherInfo(){
		String sql = "select dic_value from dbo.dic";
		final String url = "";
		jdbcTemplate.query(sql, new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				//url = rs.getString(0);
			}});
		return null;
	}
}
