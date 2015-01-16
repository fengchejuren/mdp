/**  
 * @Title: User.java 
 * @Package myfirst.domain 
 * @Description: TODO 
 * @author Rock King 2014年12月17日 下午11:36:33
 * @version V1.0  
 */
package myfirst.domain.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import myfirst.base.BasePOJO;

/**
 * @Description: TODO
 * @author Rock King 2014年12月17日 下午11:36:33
 * @see ~!^ Keep bugs away and code with U!
 */
@Entity
@Table(name = "t_user", schema = "test")
public class User extends BasePOJO implements Serializable {

	private static final long serialVersionUID = -6310809110591119027L;

	/**
	 * @Fields id : 用户id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**
	 * @Fields username :用户名
	 */
	@Column(nullable=false)
	private String username;

	/**
	 * @Fields password : 密码
	 */
	@Column(nullable=false)
	private String password;

	/**
	 * @Fields email : 用户邮箱:非空且唯一
	 */
	@Column(nullable=false,unique=true)
	private String email;

	/**
	 * @Fields registerDate :注册时间
	 */
	@Column
	private Date registerTime;
	/**
	 * @Fields credits : 用户积分
	 */
	@Column(columnDefinition="int default 0")
	private int credits;
	/**
	 * @Fields last_ip : 上次登录ip
	 */
	@Column
	private String lastVisitIp;
	/**
	 * @Fields last_visit :上次登录时间
	 */
	@Column
	private Date lastVisitTime;

	/*** @return the id */

	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */

	public void setId(int id) {
		this.id = id;
	}

	/*** @return the username */

	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */

	public void setUsername(String username) {
		this.username = username;
	}

	/*** @return the password */

	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */

	public void setPassword(String password) {
		this.password = password;
	}

	/*** @return the email */

	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */

	public void setEmail(String email) {
		this.email = email;
	}

	/*** @return the credits */

	public int getCredits() {
		return credits;
	}

	/**
	 * @param credits
	 *            the credits to set
	 */

	public void setCredits(int credits) {
		this.credits = credits;
	}

	/*** @return the lastVisitIp */

	public String getLastVisitIp() {
		return lastVisitIp;
	}

	/**
	 * @param lastVisitIp
	 *            the lastVisitIp to set
	 */

	public void setLastVisitIp(String lastVisitIp) {
		this.lastVisitIp = lastVisitIp;
	}

	/*** @return the lastVisitTime */

	public Date getLastVisitTime() {
		return lastVisitTime;
	}

	/**
	 * @param lastVisitTime
	 *            the lastVisitTime to set
	 */

	public void setLastVisitTime(Date lastVisitTime) {
		this.lastVisitTime = lastVisitTime;
	}

	/*** @return the registerTime */

	public Date getRegisterTime() {
		return registerTime;
	}

	/**
	 * @param registerTime
	 *            the registerTime to set
	 */

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

}
