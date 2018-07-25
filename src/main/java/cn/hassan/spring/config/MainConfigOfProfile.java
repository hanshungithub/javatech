package cn.hassan.spring.config;

import cn.hassan.spring.pojo.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.*;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created with idea
 * Author: hss
 * Date: 7/25/2018 4:23 PM
 * Description: 使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中;加载完外部的配置文件以后使用${}取出配置文件的值
 */
@PropertySource("classpath:/dbconfig.properties")
@Configuration
@Import(Yellow.class)
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

	@Value("${db.user}")
	private String user;

	private StringValueResolver resolver;

	private String driverClass;

	@Profile("test")
	@Bean
	public DataSource dataSourceTest(@Value("${db.password}") String pwd) {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		try {
			dataSource.setDriverClass(driverClass);
		} catch (PropertyVetoException e) {
			throw new RuntimeException("数据库连接出错");
		}
		return dataSource;
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.resolver = resolver;
		driverClass = resolver.resolveStringValue("${db.driverClass}");
	}
}
