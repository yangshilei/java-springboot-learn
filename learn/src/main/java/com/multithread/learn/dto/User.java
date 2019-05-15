package com.multithread.learn.dto;

import com.alibaba.fastjson.JSONObject;
import com.multithread.learn.annotation.MyTest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * Description：
 *
 * @Author yangshilei
 * @Date 2019-04-29 00:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Length(max = 10, message = "名称长度不能超过10个字符")
  private String name;

  @NotNull(message = "年龄不能为null")
  private Integer age;

  @Length(max = 50, message = "地址长度不能超过50个字符")
  private String message;

  @Email(message = "邮件地址不符合要求")
  private String email;

  @Override
  public String toString () {
      return JSONObject.toJSONString(this);
  }
}
