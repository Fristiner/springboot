package com.ma.service;

/* *
 * @packing com.ma.service
 * @author mtc
 * @date 13:55 10 30 13:55
 *
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private BookService bookService;


    @Autowired

    private IBookService iBookService;
     @Test
    public void testGetById(){
        System.out.println(bookService.getById(4));
    }
    @Test
    void test01(){
         iBookService.getById(1);
    }



}
