package com.multithread.learn.config;

import com.multithread.learn.pojo.UserReq;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * @Author ：yangshilei
 * @Date ：2020/6/9 14:29
 * @Description：bean配置类
 */
@Configuration
public class BeanConfig {

	/**
	 * 需要通过反射能获取到执行的类，必须先配置bean，否则无法找到对应bean的存在；
	 * @return
	 */
    @Bean
	public UserReq getUserReq(){
		return new UserReq();
	}

}
