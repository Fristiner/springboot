package com.ma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SSMPApplication {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		// 如果希望不用临时属性来进行
//		SpringApplication.run(SSMPApplication.class);
		SpringApplication.run(SSMPApplication.class, args);
	}

}
