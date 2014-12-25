package myfirst.test;

import myfirst.domain.vo.LoginCommand;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class BeanFactoryTest {

	public static void main(String[] args) {
		ResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
		Resource rs1 = patternResolver.getResource("classpath:config/applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(rs1);
		LoginCommand loginCommand = factory.getBean("loginCommand",LoginCommand.class);
		System.out.println(loginCommand.getUserName());
		
	}
}
