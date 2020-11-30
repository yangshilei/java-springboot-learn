package com.multithread.learn.service.impl;

import com.multithread.learn.config.SpringContextHolder;
import com.multithread.learn.pojo.UserReq;
import com.multithread.learn.service.ReflexService;
import com.multithread.learn.share.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author ：yangshilei
 * @Date ：2020/6/9 10:29
 * @Description：
 */
@Slf4j
@Service
public class ReflexServiceImpl implements ReflexService {

    @Override
    public Result getBean() {
        log.info("进入测试SpringContextHolder获取bean的方法中");
        String name = "com.multithread.learn.pojo.UserReq";
        try {
            Class<?> c = Class.forName(name);
            log.info("获取的类=={}",c.getSimpleName());
            UserReq userReq = (UserReq)SpringContextHolder.getBean(c);
            userReq.setName("yangshilei");
            userReq.setAge(18);
            userReq.setEmail("xxxxx@qq.com");
            userReq.setCompanyId(12);
            return Result.ok(userReq);

        } catch (ClassNotFoundException e) {
            log.error("Class获取类错误异常==={}",e);
        }
        return Result.ok("");
    }
}
