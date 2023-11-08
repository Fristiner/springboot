package com.ma.controller;


import com.ma.pojo.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public String getById(){
        System.out.println("getByID is running ");
        return "spring boot ";
    }

    @GetMapping("json")
    public Book returnByBook(){
        System.out.println("returnByBook() is running ");
        Book book1 = new Book();
        book1.setDes("springboot");
        book1.setId(1);
        book1.setType("springboot");
        book1.setName("springboot");
        return book1;
    }
}
