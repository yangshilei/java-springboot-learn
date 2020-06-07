package com.multithread.learn.reflex;

import com.multithread.learn.pojo.UserReq;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflexUtil {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        System.out.println(14433);
        Class<?> aClass = Class.forName("com.multithread.learn.pojo.UserReq");

        // 1.反射默认是new无参构造函数方法,如果没有无参构造函数，会报异常
        UserReq userReq = (UserReq) aClass.newInstance();
        userReq.setName("yangshilei");
        System.out.println("1."+userReq.getName());

        // 2.获取某个有参的构造函数实例（只能识别参数类型，不能识别名称）
        Constructor<?> constructor = aClass.getConstructor(String.class,String.class);
        UserReq userReq1 = (UserReq) constructor.newInstance("有参构造方法调用尝试","2668777@qq.com");
        System.out.println("2."+userReq1.getName()+"==="+userReq1.getEmail());

        // 3.利用反射给属性赋值
        Field field = aClass.getDeclaredField("name");
        field.setAccessible(true); // 获取权限，允许给private类型的属性赋值
        field.set(userReq,"张三");
        System.out.println("3.给反射生成的实例属性赋值==="+userReq.getName());

        Method declaredMethod = aClass.getDeclaredMethod("addName",String.class);
        Object jack = declaredMethod.invoke(userReq, "jack");
        System.out.println("4.反射调用方法"+jack);
    }
}
