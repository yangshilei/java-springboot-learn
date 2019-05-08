package com.multithread.learn.factory;

import com.multithread.learn.annotation.MyTest;
import com.multithread.learn.dto.User;

import java.lang.reflect.Method;

/**
 * Description：
 *
 * @Author yangshilei
 * @Date 2019-05-08 17:59
 */
public class UserAnnotationFactory {

  public static User createUser(){
    User user = new User();
    Method[] methods = User.class.getMethods();
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
