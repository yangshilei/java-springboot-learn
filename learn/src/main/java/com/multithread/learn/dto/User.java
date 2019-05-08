package com.multithread.learn.dto;

import com.alibaba.fastjson.JSONObject;
import com.multithread.learn.annotation.MyTest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  @MyTest(value = "xiaowang")
  private String name;

  private Integer age;
  @MyTest(value = "南京")
  private String message;
  @MyTest(value = "写代码")
  private String hobby;

  @Override
  public String toString () {
      return JSONObject.toJSONString(this);
  }
}
