package com.multithread.learn.threads;

import com.multithread.learn.dao.UserDao;
import com.multithread.learn.dto.UserDto;
import com.multithread.learn.pojo.UserReq;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Description：
 *
 * @Author yangshilei
 * @Date 2019-10-24 15:54
 */
@Slf4j
public class UserThread implements Runnable {

  private UserReq userReq;

  private UserDao userDao;

  private CountDownLatch countDownLatch;

  public UserThread (UserReq userReq,UserDao userDao,CountDownLatch countDownLatch){
    this.userReq = userReq;
    this.userDao = userDao;
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    log.info("进入多线程实现方法中");
    Integer companyId = userReq.getCompanyId();
    List<UserDto> userDtos = userDao.selectUsers(userReq.getCompanyId());
    for(int i = 0; i<2;i++){
      countDownLatch.countDown();
    }
    log.info("查询的结果==={}",userDtos.toString());
  }
}
