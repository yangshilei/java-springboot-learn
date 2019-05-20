package com.multithread.learn.dto;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
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
 * @Author yangshilei
 * @Date 2019-04-29 00:31
 */
@Data
public class UserDto {

  private Integer id;

  private String name;

  private Integer age;

  private String email;

  @JSONField(format = "yyyy-MM-dd  HH:mm:ss")
  private String createTime;

  private Integer companyId;

  @Override
  public String toString () {
      return JSONObject.toJSONString(this);
  }
}
