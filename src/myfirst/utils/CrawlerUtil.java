package myfirst.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import myfirst.domain.vo.CrawlerVO;

/**
 * 网络爬虫工具
 * 
 * @author Administrator
 *
 */
public class CrawlerUtil {

	/**
	 * 新浪网抓取内容的id
	 */
	public final static String CRAWLER_SINA_CONTENTID = "xy-impcon-A";

	/**
	 * 新浪网址
	 */
	public final static String CRAWLER_SINA_URL = "http://www.sina.com";
	
	/**
	 *网易抓取内容的id 
	 */
	public final static String CRAWLER_163_CONTENTID = "layout-news";

	/**
	 * 网易网址
	 */
	public final static String CRAWLER_163_URL = "http://www.163.com";
	
	/**
	 * 抓取的内容放进一个List里面
	 */
	public static List<CrawlerVO> crawlerVOs = new ArrayList<CrawlerVO>();
	
	/**抓取网页内容的超链接
	 * @param urlStr
	 * @return
	 */
	public static void downloadFile(String urlStr,String contentId) {
		URL url = null;
		InputStream is = null;
		BufferedReader in = null;
		StringBuffer buffer = new StringBuffer();
		try {
			url = new URL(urlStr);
			URLConnection connection = url.openConnection();
			connection.setConnectTimeout(500); // 500毫秒没有请求成功则不再发送请求
			is = connection.getInputStream();
			in = new BufferedReader(new InputStreamReader(is,"gb2312"));
			String line;
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
			Document document = Jsoup.parse(buffer.toString());
			Element element = document.getElementById(contentId);
			Elements elements = element.getElementsByTag("a");
			for(Element el:elements){
				if(el.text().length()>=10){		//排除二级目录（比如专题，专栏，视频等）
					CrawlerVO vo = new CrawlerVO();
					vo.setUrl(el.absUrl("href"));
					vo.setTitle(el.text());
					crawlerVOs.add(vo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		//清空内存，关闭资源
			try {
				in.close();
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**抓取网页内容的超链接
	 * @param url
	 */
	public static void downloadFile(String url){
		if(CRAWLER_163_URL.equals(url)){
			downloadFile(url, CRAWLER_163_CONTENTID);
		}else if(CRAWLER_SINA_URL.equals(url)){
			downloadFile(url,CRAWLER_SINA_CONTENTID);
		}
	}
	
	public static void main(String[] args) {
		//downloadFile("http://www.sina.com.cn");
		downloadFile("http://www.163.com",CRAWLER_163_CONTENTID);
	}

}
