package cn.hassan.spring.config;

import cn.hassan.spring.aop.MathCalculator;
import cn.hassan.spring.context.MyApplicationContext;
import cn.hassan.spring.pojo.Person;
import cn.hassan.spring.pojo.Yellow;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

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

	@Test
	public void test04() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		//1、创建一个applicationContext
		//2、设置需要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("test");
		//3、注册主配置类
		applicationContext.register(MainConfigOfProfile.class);
		//4、启动刷新容器
		applicationContext.refresh();


		String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
		for (String string: namesForType) {
			System.out.println(string);
		}

		Yellow bean = applicationContext.getBean(Yellow.class);
		System.out.println(bean);
		applicationContext.close();
	}

	@Test
	public void test05() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

		MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);

		mathCalculator.div(1, 1);

		applicationContext.close();
	}
}
