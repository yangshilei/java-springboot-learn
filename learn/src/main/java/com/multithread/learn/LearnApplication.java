package com.multithread.learn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.multithread.learn.pojo.UserReq;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@MapperScan("com.multithread.learn.dao")
@SpringBootApplication
@EnableAsync
public class LearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);
	}

	@Bean
	public Gson gson() {
		return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	}

	@Bean
	public UserReq getUserReq(){
		return new UserReq();
	}
}
