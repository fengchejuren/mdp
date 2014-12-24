/**  
 * @Title: User.java 
 * @Package myfirst.domain 
 * @Description: TODO 
 * @author Rock King 2014年12月17日 下午11:36:33
 * @version V1.0  
 */ 
package myfirst.domain;

import java.io.Serializable;
import java.sql.Date;

/** 
 * @Description: TODO
 * @author Rock King 2014年12月17日 下午11:36:33 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class User implements Serializable {

	private int id;
	private String userName;
	private String pwd;
	private int credits;
	private String last_ip;
	private Date last_visit;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}
	/**
	 * @param credits the credits to set
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}
	/**
	 * @return the last_ip
	 */
	public String getLast_ip() {
		return last_ip;
	}
	/**
	 * @param last_ip the last_ip to set
	 */
	public void setLast_ip(String last_ip) {
		this.last_ip = last_ip;
	}
	/**
	 * @return the last_visit
	 */
	public Date getLast_visit() {
		return last_visit;
	}
	/**
	 * @param last_visit the last_visit to set
	 */
	public void setLast_visit(Date last_visit) {
		this.last_visit = last_visit;
	}
	
}
