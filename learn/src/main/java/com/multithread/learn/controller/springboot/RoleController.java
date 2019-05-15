package com.multithread.learn.controller.springboot;

import com.multithread.learn.config.DogConfig;
import com.multithread.learn.dto.User;
import com.multithread.learn.factory.UserAnnotationFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Description：
 *
 * @Author yangshilei
 * @Date 2019-04-28 23:40
 */
@RestController
@RequestMapping("")
@Api(tags = "角色接口控制层")
public class RoleController {

  private final DogConfig dogConfig;

  @Autowired
  public RoleController(DogConfig dogConfig){
    this.dogConfig = dogConfig;
  }

  @ApiOperation(value = "测试接口",notes = "测试接口")
  @PostMapping("/get/users")
  Object test(@RequestBody @Valid User request){
    System.out.println(123);
    // application-dev.yml配置文件中配置了狗的属性信息
    return dogConfig.getPlay();
  }



}
