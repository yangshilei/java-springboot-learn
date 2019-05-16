package com.multithread.learn.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.multithread.learn.dao.UserDao;
import com.multithread.learn.dto.UserDto;
import com.multithread.learn.pojo.UserReq;
import com.multithread.learn.service.UserService;
import com.multithread.learn.share.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

  private final UserDao userDao;

  @Autowired
  public UserServiceImpl(UserDao userDao){
    this.userDao = userDao;
  }


  /**
   * 查询公司下用户列表
   */
  @Override
  public Result getUsers(UserReq request) {
    log.debug("进入获取公司员工列表方法==={}",request);
    List<UserReq> list = new ArrayList<>();
    List<UserDto> users = userDao.selectUsers(request.getCompanyId());
    log.debug("查询出的用户集合==={}",users);
    return Result.ok(users);
  }
}
