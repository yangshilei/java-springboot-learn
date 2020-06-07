package com.multithread.learn.pojo;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @Author yangshilei
 * @Date 2019-04-29 00:31
 */
@Data
@Slf4j
public class UserReq {
  @ApiModelProperty(value = "姓名")
  @Length(max = 10, message = "名称长度不能超过10个字符")
  private String name;

  @ApiModelProperty(value = "年龄")
  private Integer age;

  @ApiModelProperty(value = "邮箱")
  @Email(message = "邮件地址不符合要求")
  private String email;

  @ApiModelProperty(value = "所属企业id")
  @NotNull
  private Integer companyId;

  @ApiModelProperty(value = "页码")
  private Integer page;

  @ApiModelProperty(value = "页值大小")
  private Integer pageSize;

  public UserReq (){
    log.info("反射默认是new无参构造函数方法！");
  }

  public UserReq (String name){
    this.name = name;
  }

  public UserReq (String name,String email){
    this.name = name;
    this.email = email;
  }

  public String addName(String name){
    System.out.println("反射获取方法");
    return name;
  }

  @Override
  public String toString () {
      return JSONObject.toJSONString(this);
  }
}
