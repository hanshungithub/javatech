package cn.hassan.spring.context;

import cn.hassan.spring.pojo.Car;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created with idea
 * Author: hss
 * Date: 7/25/2018 4:08 PM
 * Description:
 */
@Component
public class MyApplicationContext implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void test() {
		Car car = (Car) applicationContext.getBean("car");
		System.out.println(car);
	}

}
