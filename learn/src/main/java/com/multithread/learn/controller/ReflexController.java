package com.multithread.learn.controller;

import com.multithread.learn.service.ReflexService;
import com.multithread.learn.share.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ：yangshilei
 * @Date ：2020/6/9 10:28
 * @Description：
 */
@Slf4j
@RestController
@RequestMapping("/reflex")
public class ReflexController {

    @Autowired
    private ReflexService reflexService;

    @ApiOperation(value = "测试通过反射再context中获取bean",notes = "测试通过反射再context中获取bean")
    @GetMapping("/get/bean")
    Result getBean(){
        return reflexService.getBean();
    }
}
