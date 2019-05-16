package com.multithread.learn.dao;

import com.multithread.learn.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description：持久层
 *
 * @Author yangshilei
 * @Date 2019-05-16 13:48
 */
@Repository
public interface UserDao {
  /**
   * 获取用户列表
   * @param companyId
   * @return
   */
  List<UserDto> selectUsers(Integer companyId);
}
