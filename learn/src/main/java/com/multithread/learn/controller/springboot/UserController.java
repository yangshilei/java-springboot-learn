package com.multithread.learn.controller.springboot;

import com.multithread.learn.config.DogConfig;
import com.multithread.learn.dto.UserDto;
import com.multithread.learn.service.UserService;
import com.multithread.learn.share.Result;
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
@Api(tags = "用户接口")
public class UserController {

  private final DogConfig dogConfig;
  private final UserService userService;

  @Autowired
  public UserController(DogConfig dogConfig,UserService userService){
    this.dogConfig = dogConfig;
    this.userService = userService;
  }

  @ApiOperation(value = "测试接口",notes = "测试接口")
  @PostMapping("/get/test")
  Object test(@RequestBody @Valid UserDto request){
    System.out.println(123);
    // application-dev.yml配置文件中配置了狗的属性信息
    return dogConfig.getPlay();
  }

  @ApiOperation(value = "获取公司用户列表",notes = "获取公司用户列表")
  @PostMapping("/get/users")
  Result getUsers(@RequestBody Integer companyId){
    return  userService.getUsers(companyId);
  }



}
