package cn.hassan.spring.config;

import cn.hassan.reflect.t3.Person;
import cn.hassan.spring.filter.MyTypeFilter;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;

/**
 * Created with idea
 * Author: hss
 * Date: 7/25/2018 2:20 PM
 * Description:
 * @ComponentScan  value:指定要扫描的包
 * excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
 * includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
 * FilterType.ANNOTATION：按照注解
 * FilterType.ASSIGNABLE_TYPE：按照给定的类型；
 * FilterType.ASPECTJ：使用ASPECTJ表达式
 * FilterType.REGEX：使用正则指定
 * FilterType.CUSTOM：使用自定义规则
 *
 * @ComponentScan(value = "cn.hassan.spring",excludeFilters = {@Filter(type=FilterType.ANNOTATION,classes={Controller.class})})
 */
@Configuration
@ComponentScans(value = {@ComponentScan(value = "cn.hassan.spring",includeFilters = {@Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})},useDefaultFilters = false)})
public class MainConfig {

	@Bean
	public Person person() {
		return new Person();
	}
}
