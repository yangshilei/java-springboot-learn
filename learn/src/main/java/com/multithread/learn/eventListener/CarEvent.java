package com.multithread.learn.eventListener;

import java.util.EventObject;

/**
 * 定义一个事件的对象，继承EventObject；
 */
public class CarEvent extends EventObject {

    private static final long serialVersionUID = 1L;

    // 汽车的状态
    private String carStatue = "";

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CarEvent(Object source,String carStatue) {
        super(source);
        this.carStatue = carStatue;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCarStatue() {
        return carStatue;
    }

    public void setCarStatue(String carStatue) {
        this.carStatue = carStatue;
    }
}
