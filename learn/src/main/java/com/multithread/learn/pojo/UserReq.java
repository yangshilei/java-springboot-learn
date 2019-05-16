package com.multithread.learn.pojo;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @Author yangshilei
 * @Date 2019-04-29 00:31
 */
@Data
public class UserReq {
  @ApiModelProperty(value = "姓名")
  @Length(max = 10, message = "名称长度不能超过10个字符")
  private String name;

  @ApiModelProperty(value = "年龄")
  private Integer age;

  @ApiModelProperty(value = "邮箱")
  @Email(message = "邮件地址不符合要求")
  private String email;

  @NotNull
  private Integer companyId;

  @ApiModelProperty(value = "页码")
  private Integer page;

  @ApiModelProperty(value = "页值大小")
  private Integer pageSize;

  @Override
  public String toString () {
      return JSONObject.toJSONString(this);
  }
}
