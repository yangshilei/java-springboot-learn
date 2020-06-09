package com.multithread.learn.config;

import com.multithread.learn.pojo.UserReq;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ：yangshilei
 * @Date ：2020/6/9 14:29
 * @Description：bean配置类
 */
@Configuration
public class BeanConfig {
    @Bean
	public UserReq getUserReq(){
		return new UserReq();
	}
}
