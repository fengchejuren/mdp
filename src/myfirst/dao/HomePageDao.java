/**  
 * @Title: HomePageDao.java 
 * @Package myfirst.dao 
 * @Description: TODO 
 * @author Rock King 2014年12月29日 下午11:08:58
 * @version V1.0  
 */
package myfirst.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import myfirst.base.BaseDAO;
import myfirst.domain.vo.CrawlerVO;
import myfirst.utils.CrawlerUtil;

import org.springframework.beans.BeanUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

/**
 * @Description: TODO
 * @author Rock King 2014年12月29日 下午11:08:58
 * @see ~!^ Keep bugs away and code with U!
 */
@Repository
public class HomePageDao extends BaseDAO {

	/**
	 * 存储CrawlerUtil.crawlerVOs的缓存信息。当正处于抓取新闻时CrawlerUtil.crawlerVOs清空，数据从tempList里面
	 */
	private static List<CrawlerVO> tempList = new ArrayList<>();
	/**
	 * 定时抓取新浪、网易等网站的新闻头条
	 * 
	 * @see Any changes please send mail to:superman166@126.com ~!^ Keep bugs
	 *      away and code with U!
	 */
	@Scheduled(cron="0 0 5,16 * * ?")	//每天凌晨5点钟，下午4点钟进行一次抓取
	public void updateFileList() {
		Date begin = new  Date();
		logger.info("slf4j日志记录进行了一次抓取，开始时间是："+begin.toString());
		for(CrawlerVO crawlerVO:CrawlerUtil.crawlerVOs){
			CrawlerVO vo = new  CrawlerVO();
			BeanUtils.copyProperties(crawlerVO, vo);
			tempList.add(vo);
		}
		CrawlerUtil.crawlerVOs.clear();
		CrawlerUtil.downloadFile(CrawlerUtil.CRAWLER_163_URL);
		CrawlerUtil.downloadFile(CrawlerUtil.CRAWLER_SINA_URL);
		Date end = new Date();
		logger.info("进行了一次抓取，结束时间是："+end.toString()+". 花费时间是"+(end.getTime()-begin.getTime()));
		tempList.clear();
	}

	/**从CrawlerUtil.crawlerVOs中随机取5条记录
	 * @see Any changes please send mail to:superman166@126.com  
	 * ~!^ Keep bugs away and code with U!	
	 */
	public List<CrawlerVO> getCrawlerVOList() {
		List<CrawlerVO> list = new ArrayList<CrawlerVO>();
		Random random = new Random();
		if (!CrawlerUtil.crawlerVOs.isEmpty()) {
			for (int i = 0; i < 5; i++) {
				CrawlerVO crawlerVO = CrawlerUtil.crawlerVOs.get(random
						.nextInt(CrawlerUtil.crawlerVOs.size()));
				if (!list.contains(crawlerVO)) {
					list.add(crawlerVO);
				}
			}
		}
		return list;
	}
}
