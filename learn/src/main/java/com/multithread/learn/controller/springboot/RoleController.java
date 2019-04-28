package com.multithread.learn.controller.springboot;

import com.multithread.learn.dto.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  @ApiOperation(value = "测试接口",notes = "测试接口")
  @PostMapping("/get/users")
  String test(@RequestBody User request){

    // git仓库，master主支代码拉到dev分支上
    return "hello world";
  }


}
