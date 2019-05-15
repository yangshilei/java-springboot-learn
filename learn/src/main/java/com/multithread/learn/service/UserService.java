package com.multithread.learn.service;

import com.multithread.learn.dto.User;
import com.multithread.learn.share.Result;

import java.util.List;

public interface UserService {

  /**
   * 查询公司下用户列表
   * @param companyId
   * @return
   */
  Result getUsers(Integer companyId);


}
