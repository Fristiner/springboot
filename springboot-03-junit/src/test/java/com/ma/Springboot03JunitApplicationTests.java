package com.ma;

import com.ma.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// 不在这个com.ma下的时候需要添加classes
// 测试类找不到引导类
@SpringBootTest(classes = Springboot03JunitApplicationTests.class)
class Springboot03JunitApplicationTests {
	/*
	* TODO：springboot测试使用方式 自动装配的方法
	*  1.注入要测试的对象
	*  2.执行要测试对象的方法
	*  3.主要的核心是@SpringbootTest
	*
	* */

	@Autowired
	private BookMapper bookMapper;


	@Test
	void contextLoads() {
		System.out.println("test.....");
	}

	@Test
	void test01(){
		bookMapper.save();
	}
}
