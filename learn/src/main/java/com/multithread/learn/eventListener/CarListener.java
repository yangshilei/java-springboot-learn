package com.multithread.learn.eventListener;

import java.util.EventListener;

/**
 * 定义监听接口，负责监听CarEvent事件，在监听到事件以后执行具体的操作
 */
public interface CarListener extends EventListener {

    void carEvent(CarEvent event);

}
