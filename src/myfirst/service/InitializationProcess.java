/**  
 * @Title: InitializationProcess.java 
 * @Package myfirst.service 
 * @Description: TODO 
 * @author Rock King 2014年12月30日 上午12:30:49
 * @version V1.0  
 */ 
package myfirst.service;

import myfirst.dao.HomePageDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/** 
 * @Description: TODO
 * @author Rock King 2014年12月30日 上午12:30:49 
 * @see ~!^ Keep bugs away and code with U!	 
 */

/** 启动spring容器后立即执行的方法（如加载配置项等）
 * @Description: TODO
 * @author Rock King 2014年12月30日 上午12:35:57 
 * @see ~!^ Keep bugs away and code with U!	 
 */ 
@Component
public class InitializationProcess implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private HomePageDao homePageDao;
	/* 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent) 
	 */ 
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//root application context 没有parent，他就是老大.避免在执行projectName-servlet  context时再执行一次
		if(event.getApplicationContext().getParent()==null){
			homePageDao.updateFileList();	//spring 容器执行完毕以后，抓取一次网页内容
		}
	}

}
