package com.multithread.learn.reflex;

public class ReflexUtil {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(123);
        Class<?> aClass = Class.forName("com.multithread.learn.pojo.UserReq");
        String simpleName = aClass.getSimpleName();
        System.out.println(simpleName);
        System.out.println(133);
    }
}
