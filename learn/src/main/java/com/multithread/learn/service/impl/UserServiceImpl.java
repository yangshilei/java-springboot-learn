package com.multithread.learn.service.impl;

import com.multithread.learn.dao.UserDao;
import com.multithread.learn.dto.UserDto;
import com.multithread.learn.pojo.UserReq;
import com.multithread.learn.service.UserService;
import com.multithread.learn.share.Result;
import com.multithread.learn.threads.UserThread;
import com.multithread.learn.util.MyPropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.*;
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

  private RestTemplate restTemplate;

  @Autowired
  public UserServiceImpl(UserDao userDao,RestTemplate restTemplate){
    this.userDao = userDao;
    this.restTemplate = restTemplate;
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
      ExecutorService pool = Executors.newFixedThreadPool(3);
      for(int i =0; i<3; i++){
        pool.execute(new UserThread(request,userDao,countDownLatch));
      }
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

  /**
   * 测试restTemplate查询天气接口
   * @return
   */
  @Override
  public Result testRestTemplate() {
    log.info("进入测试restTemplate发送消息方法");
    String url = "http://wthrcdn.etouch.cn/weather_mini?citykey=101280601";
    ResponseEntity<String> forEntity = restTemplate.getForEntity(url,String.class);
    log.info("响应的结果==={}",forEntity);
    return Result.ok(forEntity);
  }


  private Map<String,String> initMap;

  /**
   * 用@PostConstruct初始化一个map集合，并模拟封装一些初始化值；
   */
  @PostConstruct
  @Override
  public void createMap(){
    log.info("开始初始化map对象值");
    initMap = new HashMap<>();
    initMap.put("name","yangshilei");
    initMap.put("age","23");
    initMap.put("hubby","games");
    log.info("初始化之后的值==={}",initMap.toString());
    return;
  }

  /**
   * 查询初始数据的接口
   * @return
   */
  @Override
  public Result getMapObject(){
    log.info("进入获取初始值的方法");
    Set<String> strings = initMap.keySet();
    log.info("集合中的键值集合==={}",strings);
    return Result.ok(initMap);
  }

  public static void main(String[] args) {
    String name = MyPropertiesUtil.getValue("name");
    System.out.println(name);
  }
}
