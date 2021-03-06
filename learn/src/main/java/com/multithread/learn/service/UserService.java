package com.multithread.learn.service;

import com.multithread.learn.pojo.UserReq;
import com.multithread.learn.share.Result;

public interface UserService {

  /**
   * 查询公司下用户列表
   * @param companyId
   * @return
   */
  Result getUsers(UserReq companyId);

  /**
   * 多线程查询测试
   * @param request
   * @return
   */
  Result testThreadPool( UserReq request);
}
