package com.multithread.learn.service.impl;

import com.multithread.learn.dao.UserDao;
import com.multithread.learn.dto.UserDto;
import com.multithread.learn.pojo.UserReq;
import com.multithread.learn.service.UserService;
import com.multithread.learn.share.Result;
import com.multithread.learn.threads.UserThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

  /**
   * 多线程查询测试
   * @param request
   * @return
   */
  @Override
  public Result testThreadPool(UserReq request) {
    log.info("开始多线程测试方法，入参==={}",request.toString());
    // 1.如果companyId=1，不走多线程
    if(request.getCompanyId().equals(1)){
      log.info("单线程方法");
      List<UserDto> users = userDao.selectUsers(request.getCompanyId());
      return Result.ok("单线程查询",users);
    }
    // 2.如果companyId=2，走多线程
    if(request.getCompanyId().equals(2)){
      log.info("多线程方法");
      CountDownLatch countDownLatch = new CountDownLatch(3);
      ExecutorService pool = Executors.newFixedThreadPool(1);
      pool.execute(new UserThread(request,userDao,countDownLatch));
      try {
        countDownLatch.await();
      } catch (InterruptedException e) {
        log.error("多线程计数器异常---{}",e.getMessage());
      }finally {
        pool.shutdown();
      }
      log.info("主线程结束");
    }
    return Result.ok("测试成功！");
  }
}
