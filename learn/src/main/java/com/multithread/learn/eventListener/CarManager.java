package com.multithread.learn.eventListener;

import java.util.HashSet;
import java.util.Set;

/**
 * 事件源对象，在这里你可以把它想象成一个控制车的挡位。
 * (如果是在swing中，就类似一个button)
 */
public class CarManager {

    private Set<CarListener>  set = new HashSet<>();

    /**
     * 添加事件
     */
    public void addCarListener(CarListener carListener){
        set.add(carListener);
    }

    /**
     * 移除监听事件
     */
    public void removeCarListener(CarListener carListener){
        set.remove(carListener);
    }


    /**
     * 触发开车事件
     */
    protected void dCar(){
        CarEvent carEvent = new CarEvent(this,"d");
        this.notifyListeners(carEvent);
        System.out.println("开车事件");
    }

    /**
     * 触发倒车事件
     */
    protected void rCar(){
        CarEvent carEvent = new CarEvent(this,"r");
        this.notifyListeners(carEvent);
        System.out.println("倒车事件");
    }

    /**
     * 通知所有监听器执行
     * @param carEvent
     */
    private void notifyListeners(CarEvent carEvent){
        if(!set.isEmpty()){
            for(CarListener item : set){
                item.carEvent(carEvent);
            }
        }
    }
}
