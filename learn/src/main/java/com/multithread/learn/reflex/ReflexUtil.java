package com.multithread.learn.reflex;

public class ReflexUtil {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(1443);
        Class<?> aClass = Class.forName("com.multithread.learn.pojo.UserReq");
        String simpleName = aClass.getSimpleName();
        System.out.println(simpleName);
        System.out.println(1343);
    }
}
