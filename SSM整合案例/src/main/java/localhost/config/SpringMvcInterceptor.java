package localhost.config;

import localhost.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Controller
public class SpringMvcInterceptor extends WebMvcConfigurationSupport {

    @Autowired
    private ProjectInterceptor projectInterceptor;

    @Override
    //拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器的注册器
        registry.addInterceptor(projectInterceptor).addPathPatterns("/拦截目录").excludePathPatterns("/排除目录");
    }

}
