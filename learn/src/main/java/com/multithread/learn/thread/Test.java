package com.multithread.learn.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author ：yangshilei
 * @Date ：2020/4/24 16:37
 * @Description：
 */

@EnableAsync
@Component
@Slf4j
public class Test implements ApplicationRunner {

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    @Override
    public void run(ApplicationArguments args) throws Exception {

        while (true){
            String xx = "";
            if(StringUtils.isEmpty(xx)){
                continue;
            }

            log.info("开始添加任务");
            List<Callable<Void>> tasks = new ArrayList<>();
            tasks.add(() -> {
                System.out.println("开始添加任务");
                return null;
            });

            log.info("开始执行任务");
            Thread.sleep(1000);

            executorService.invokeAll(tasks);
        }
    }


}
