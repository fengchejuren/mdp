/**  
 * @Title: LoginCommand.java 
 * @Package myfirst.web 
 * @Description: TODO 
 * @author Rock King 2014年12月18日 上午1:25:15
 * @version V1.0  
 */ 
package myfirst.domain.vo;

/** 
 * @Description: TODO
 * @author Rock King 2014年12月18日 上午1:25:15 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class LoginCommand {

	private String username;
	private String password;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return username;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.username = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
