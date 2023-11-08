package com.ma;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest(properties = {"test.prop=testvalue1"})  // testvalue1
//@SpringBootTest(args = {"--test.prop=testValue2"})  //testValue2运行结果
@SpringBootTest(properties = {"test.prop=testvalue1"},args = {"--test.prop=testValue2"})  // testvalue1
class Springboot14TestApplicationTests {

	@Value("${test.prop}")
	private String msg;

	@Test
	void contextLoads() {
		System.out.println(msg);
	}

}
