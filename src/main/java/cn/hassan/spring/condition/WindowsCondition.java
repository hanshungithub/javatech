package cn.hassan.spring.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

/**
 * Created with idea
 * Author: hss
 * Date: 7/25/2018 3:24 PM
 * Description:
 */
public class WindowsCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment environment = context.getEnvironment();
		String property = environment.getProperty("os.name");
		if (!StringUtils.isEmpty(property) && property.contains("Windows")) {
			return true;
		}
		return false;
	}
}
