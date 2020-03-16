package com.multithread.learn.jobs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Joe
 * @create 2018-11-14 15:13
 **/
@Slf4j
@Component(value = "helloJob")
public class HelloJob {

    public void hello() {
        log.info("World!" + new Date());
    }

}
