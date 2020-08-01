package springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan(basePackages= {"com.capg.model","springmvc.demo","springmvc.dao","springmvc.service"})
public class WebConfig {
	
	

}
