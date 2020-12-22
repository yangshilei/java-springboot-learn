package com.multithread.learn.eventListener;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class CarListener2 implements CarListener {

    @Override
    public void carEvent(CarEvent event) {
        if(StringUtils.isNotEmpty(event.getCarStatue())){
            switch (event.getCarStatue()){
                case "open":
                    log.info("宝马车门已打开");
                    break;
                case "d":
                    log.info("宝马前进");
                    break;
                case "p":
                    log.info("宝马停车");
                    break;
                case "r":
                    log.info("宝马倒车");
                    break;
                case "s":
                    log.info("宝马运动模式");
                    break;
                default:
                    log.info("宝马未知状态");
                    break;
            }

        }
    }
}
