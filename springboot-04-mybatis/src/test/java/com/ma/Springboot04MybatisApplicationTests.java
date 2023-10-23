package com.ma;

import com.ma.domain.Books;
import com.ma.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot04MybatisApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private BookMapper bookMapper;

	@Test
	void testBookMapper(){
	   Books books =  bookMapper.getById(1);

		System.out.println(books);
	}
}
