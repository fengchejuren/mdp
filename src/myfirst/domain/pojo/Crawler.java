/**  
 * @Title: User.java 
 * @Package myfirst.domain 
 * @Description: TODO 
 * @author Rock King 2014年12月17日 下午11:36:33
 * @version V1.0  
 */ 
package myfirst.domain.pojo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.junit.experimental.categories.Category;

import myfirst.base.BasePOJO;

/** 
 * @Description: TODO
 * @author Rock King 2014年12月17日 下午11:36:33 
 * @see ~!^ Keep bugs away and code with U!	 
 */
@Entity
@Table(name="mdp_crawler" )
public class Crawler extends BasePOJO implements Serializable {

	private static final long serialVersionUID = -6310809110591119027L;
	
	/**
	 * @Fields id : 用户id
	 */
	@Id
	@GeneratedValue
	private int id;
	/**
	 * @Fields username :用户名
	 */
	@Column
	private String first;
	
	/**
	 * @Fields password : 密码
	 */
	@Column
	private String second;
	
	/**
	 * @Fields email : 用户邮箱
	 */
	@Column
	private String third;

	/*** @return the id*/
	
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	
	public void setId(int id) {
		this.id = id;
	}

	/*** @return the first*/
	
	public String getFirst() {
		return first;
	}

	/**
	 * @param first the first to set
	 */
	
	public void setFirst(String first) {
		this.first = first;
	}

	/*** @return the second*/
	
	public String getSecond() {
		return second;
	}

	/**
	 * @param second the second to set
	 */
	
	public void setSecond(String second) {
		this.second = second;
	}

	/*** @return the third*/
	
	public String getThird() {
		return third;
	}

	/**
	 * @param third the third to set
	 */
	
	public void setThird(String third) {
		this.third = third;
	}
	
	
	}
