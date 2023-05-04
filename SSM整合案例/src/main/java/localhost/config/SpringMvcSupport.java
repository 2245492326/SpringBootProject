package localhost.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
/*  可以配置
	 配置默认的servlet+mvc的注解驱动+拦截器+异常解析器+文件上传解析器
	 视图控制器+视图解析器
*/
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {

    @Override
    //配置默认的servlet处理静态资源
    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //enable表示当前配置可用
        configurer.enable();
    }
}
