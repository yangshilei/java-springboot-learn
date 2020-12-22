package com.multithread.learn.eventListener;

public class MainTest {
    public static void main(String[] args) {
        CarManager manager = new CarManager();
        manager.addCarListener(new CarListener1());
        manager.addCarListener(new CarListener2());

        System.out.println("开始");

        manager.dCar();
        System.out.println("开了一段距离");

        manager.rCar();
        System.out.println("倒车完成");
    }
}
