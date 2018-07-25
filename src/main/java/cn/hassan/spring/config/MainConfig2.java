package cn.hassan.spring.config;

import cn.hassan.spring.condition.MyImportBeanDefinitionRegistrar;
import cn.hassan.spring.condition.WindowsCondition;
import cn.hassan.spring.pojo.Blue;
import cn.hassan.spring.pojo.Person;
import cn.hassan.spring.pojo.Yellow;
import cn.hassan.spring.selector.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created with idea
 * Author: hss
 * Date: 7/25/2018 3:22 PM
 * Description:
 * 		@Conditional() 类中组件统一设置。满足当前条件，这个类中配置的所有bean注册才能生效
 */
@Configuration
@Import({Yellow.class, Blue.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

	@Conditional({WindowsCondition.class})
	@Bean("win")
	public Person person() {
		return new Person("windows",18,"win");
	}
}
