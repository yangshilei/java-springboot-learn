package com.multithread.learn.eventListener;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class CarListener1 implements CarListener {

    @Override
    public void carEvent(CarEvent event) {
        if(StringUtils.isNotEmpty(event.getCarStatue())){
            switch (event.getCarStatue()){
                case "open":
                    log.info("奔驰车门已打开");
                    break;
                case "d":
                    log.info("奔驰前进");
                    break;
                case "p":
                    log.info("奔驰停车");
                    break;
                case "r":
                    log.info("奔驰倒车");
                    break;
                case "s":
                    log.info("奔驰运动模式");
                    break;
                default:
                     log.info("奔驰未知状态");
                     break;
            }
        }
    }
}
