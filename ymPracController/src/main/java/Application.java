import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by liwenchao on 2015/10/14.
 * Spring boot 启动文件
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.ymPrac")
public class Application extends WebMvcConfigurerAdapter{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 配置拦截器
     * @author lance
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new HttpApiInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new LoginRequiredInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new InterfaceSecurityInteceptor()).addPathPatterns("/api/**");
    }
}
