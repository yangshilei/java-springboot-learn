package com.multithread.learn.service.impl;

import com.multithread.learn.dto.User;
import com.multithread.learn.service.UserService;
import com.multithread.learn.share.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：用户模块业务逻辑层
 * @Author yangshilei
 * @Date 2019-05-15 14:12
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

  /**
   * 查询公司下用户列表
   */
  @Override
  public Result getUsers(Integer companyId) {
    log.debug("进入获取公司员工列表方法==={}",companyId);
    List<User> list = new ArrayList<>();
    User user = new User();
    user.setName("tom");
    user.setAge(12);
    user.setEmail("2668597787@qq.com");
    user.setMessage("南京秦淮区通服大厦");
    list.add(user);
    log.info("集合查询结束!==={}",list);
    return Result.ok(list);
  }
}
