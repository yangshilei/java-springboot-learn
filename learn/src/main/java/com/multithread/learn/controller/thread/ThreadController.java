package com.multithread.learn.controller.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

/**
 * @Author yangshilei
 * @Date 2019-05-17 09:59
 */
@RestController
@Api(tags = "多线程接口")
public class ThreadController {

  public static void main(String[] args) {
    System.out.println(1234);
    final int Size = 4;
    final long keepAliveTime = 0L;
    ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("FS-t-%d").build();
    ThreadPoolExecutor pool =
        new ThreadPoolExecutor(Size,Size,keepAliveTime, MILLISECONDS,new LinkedBlockingQueue<Runnable>(), factory);

    // TODO 待处理
    pool.execute(() -> {
      System.out.println(23);
    });

  }
}
