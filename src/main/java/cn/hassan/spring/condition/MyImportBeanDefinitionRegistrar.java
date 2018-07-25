package cn.hassan.spring.condition;

import cn.hassan.spring.pojo.Register;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created with idea
 * Author: hss
 * Date: 7/25/2018 3:47 PM
 * Description:
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * AnnotationMetadata：当前类的注解信息
	 * BeanDefinitionRegistry:BeanDefinition注册类；
	 * 		把所有需要添加到容器中的bean；调用
	 * 		BeanDefinitionRegistry.registerBeanDefinition手工注册进来
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		boolean definition = registry.containsBeanDefinition("cn.hassan.spring.pojo.Yellow");
		boolean definition2 = registry.containsBeanDefinition("cn.hassan.spring.pojo.Blue");
		if(definition && definition2){
			//指定Bean定义信息；（Bean的类型，Bean。。。）
			RootBeanDefinition beanDefinition = new RootBeanDefinition(Register.class);
			//注册一个Bean，指定bean名
			registry.registerBeanDefinition("register", beanDefinition);
		}
	}
}
