package com.ma.mapper;

import com.ma.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/* *
 * @packing com.ma.mapper
 * @author mtc
 * @date 15:16 10 21 15:16
 *
 */
@SpringBootTest
public class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void test(){
        Book book = bookMapper.getById(1);
        System.out.println(book);

    }

}
