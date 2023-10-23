package com.ma;

import com.ma.domain.Book;
import com.ma.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot05MybatisPlusApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private BookMapper bookMapper;

    @Test
    void  testBookMapper(){
       Book book =  bookMapper.selectById(1);
        System.out.println(book);
        System.out.println(bookMapper.selectList(null));
    }
}
