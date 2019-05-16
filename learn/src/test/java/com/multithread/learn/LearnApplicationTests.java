package com.multithread.learn;

import com.multithread.learn.dto.UserDto;
import com.multithread.learn.factory.UserAnnotationFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnApplicationTests {


	@Test
	public void contextLoads() {
		System.out.println();
	}

  @Test
	public void annotationTest(){
    // 注解自动引入测试
    System.out.println(123);
    // User 属性上未添加测试注解，次处不生效
    UserDto user = UserAnnotationFactory.createUser();
    System.out.println(user.getName());
  }

}
