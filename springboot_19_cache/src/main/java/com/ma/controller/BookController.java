package com.ma.controller;

import com.ma.domain.Book;
import com.ma.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public Book getByID(@PathVariable ("id") Integer id){
        return bookService.getByID(id);
    }

    @GetMapping()

    public List<Book> getAll(){
        return bookService.getAll();
    }

}
