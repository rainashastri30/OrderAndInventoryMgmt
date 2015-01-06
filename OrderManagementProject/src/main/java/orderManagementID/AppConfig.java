package orderManagementID;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mongodb.Mongo;
 
@EnableWebMvcSecurity
@Configuration
@ComponentScan()
//@Import({ SecurityConfig.class })
public class AppConfig {
 
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/mysampleschema");
	    driverManagerDataSource.setUsername("root");
	    driverManagerDataSource.setPassword("mypassword");
	    return driverManagerDataSource;
	}
// 
//	@Bean
//	public InternalResourceViewResolver viewResolver() {
//	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//	    viewResolver.setViewClass(JstlView.class);
//	    viewResolver.setPrefix("/src/main/resources/templates/");
//	    viewResolver.setSuffix(".jsp");
//	    return viewResolver;
//	}
	
//	 public @Bean MongoFactoryBean mongo() {
//         MongoFactoryBean mongo = new MongoFactoryBean();
//         mongo.setHost("localhost");
//         return mongo;
//    }
 
}