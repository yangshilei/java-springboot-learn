package com.multithread.learn.dto;

import com.alibaba.fastjson.JSONObject;
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

  private String name;

  private Integer age;

  private String message;

  private String hobby;

  @Override
  public String toString () {
      return JSONObject.toJSONString(this);
  }
}
