package localhost.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//springmvc配置类，本质上还是一个spring配置类
@Configuration
@ComponentScan({"localhost.controller", "localhost.config"})
@EnableWebMvc//开启JSON转换成对象的功能
//@Import(SpringMvcSupport.class)
public class SpringMvcConfig {
}