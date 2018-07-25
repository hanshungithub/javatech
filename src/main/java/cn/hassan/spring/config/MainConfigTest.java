package cn.hassan.spring.config;

import cn.hassan.spring.context.MyApplicationContext;
import cn.hassan.spring.pojo.Person;
import cn.hassan.spring.pojo.Yellow;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with idea
 * Author: hss
 * Date: 7/25/2018 2:29 PM
 * Description:
 */
public class MainConfigTest {

	@Test
	public void test01() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}

	@Test
	public void test02() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		Yellow yellow = applicationContext.getBean(Yellow.class);
		Person win = (Person) applicationContext.getBean("win");
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}

	@Test
	public void test03() {
		//1、创建ioc容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建完成...");
		//applicationContext.getBean("car");
		//关闭容器
		applicationContext.close();
	}
}