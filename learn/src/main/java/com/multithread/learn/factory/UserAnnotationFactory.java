package com.multithread.learn.factory;

import com.multithread.learn.annotation.MyTest;
import com.multithread.learn.dto.UserDto;

import java.lang.reflect.Method;

/**
 * Description：自定义注解的学习使用
 *
 * @Author yangshilei
 * @Date 2019-05-08 17:59
 */
public class UserAnnotationFactory {

  public static UserDto createUser(){
    UserDto user = new UserDto();
    Method[] methods = UserDto.class.getMethods();
    try {
      for(Method method : methods){
        if(method.isAnnotationPresent(MyTest.class)){
          MyTest annotation = method.getAnnotation(MyTest.class);
          method.invoke(user,MyTest.class);
        }
      }
    }catch (Exception e ){
      return null;
    }
    return user;
  }
}
