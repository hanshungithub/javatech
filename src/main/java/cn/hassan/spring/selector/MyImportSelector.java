package cn.hassan.spring.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created with idea
 * Author: hss
 * Date: 7/25/2018 3:43 PM
 * Description:
 */
public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"cn.hassan.spring.pojo.RainBow"};
	}
}
