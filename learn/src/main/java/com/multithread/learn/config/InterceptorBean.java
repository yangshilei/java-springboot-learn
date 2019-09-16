package com.multithread.learn.config;

import com.multithread.learn.Interceptor.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description：拦截器配置文件
 * @Author yangshilei
 * @Date 2019-05-20 15:56
 */
@Configuration
public class InterceptorBean implements WebMvcConfigurer {

  /**
   * 在容器中添加请求拦截器
   * @return
   */
  @Bean
  public RequestInterceptor requestInterceptor(){
    return new RequestInterceptor();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(this.requestInterceptor())
        .addPathPatterns("/learn/**")
        .excludePathPatterns("/learn/user")
        .order(1);
  }
}
