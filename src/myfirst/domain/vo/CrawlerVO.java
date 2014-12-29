package myfirst.domain.vo;

import java.sql.Date;

/**网络爬虫抓取的东西
 * @author Administrator
 *
 */
public class CrawlerVO {

	/**
	 * 一级目录（资源来源，比如新浪，网易等）
	 */
	private String aDirectory;	
	
	/**
	 * 二级目录（分类，比如财经，社会等）
	 */
	private String bDirectory;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * url地址
	 */
	private String url;
	
	/**
	 * 描述（取内容的第一段）
	 */
	private String desc;
	
	/**
	 * 抓取时间
	 */
	private Date createDate;

	public String getaDirectory() {
		return aDirectory;
	}

	public void setaDirectory(String aDirectory) {
		this.aDirectory = aDirectory;
	}

	public String getbDirectory() {
		return bDirectory;
	}

	public void setbDirectory(String bDirectory) {
		this.bDirectory = bDirectory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
