package com.multithread.learn.config;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Description：狗的配置类
 *
 * @Author yangshilei
 * @Date 2019-05-13 10:48
 */
@Component
@Configuration
@Data
@ConfigurationProperties(value = "animal.dog")
@Validated
public class DogConfig {

  @Length(max = 5,message = "狗的配置名称长度不能超过5个字符")
  private String name;

  @NotNull
  private Integer age;

  @NotNull
  private List<String> play;

  @Override
  public String toString () {
      return JSONObject.toJSONString(this);
  }
}
