package com.multithread.learn.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Description：swagger2配置类
 * @Author yangshilei
 * @Date 2019-04-29 00:05
 */
@Configuration
public class SwaggerConfig {

  @Bean
  public Docket myDocket() {
    Docket docket = new Docket(DocumentationType.SWAGGER_2);
    ApiInfo apiInfo = new ApiInfoBuilder()
        .title("SpingBoot---Api接口文档") // 标题
        .description("个人学习项目") // 描述
        .contact(new Contact("", "", ""))
        .version("1.0") // 版本号
        .build();
    docket.apiInfo(apiInfo);
    //设置只生成被Api这个注解注解过的Ctrl类中有ApiOperation注解的api接口的文档
    docket.select().apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
    return docket;
  }

}
