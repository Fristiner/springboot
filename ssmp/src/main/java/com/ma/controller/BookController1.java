package com.ma.controller;

/* *
 * @packing com.ma.controller
 * @author mtc
 * @date 14:14 10 30 14:14
 *
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ma.pojo.Book;
import com.ma.service.IBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController1 {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll(){
        return bookService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.update(book,null);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable("id") Integer id){
        return bookService.removeById(id);
    }

    @GetMapping("{id}")
    public Book getByID(@PathVariable("id") Integer id)
    {
        return bookService.getById(id);
    }
    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Book> getPage(@PathVariable(required = false) Integer currentPage,
                               @PathVariable(required = false) Integer pageSize){
        return bookService.getPage(currentPage,pageSize);
    }
    // PathVariable 路径参数
    //@RequestParam(required = false,defaultValue = "")
    // 这样类型的参数使用
    // http://localhost:8080/book?name=xiaoming&age=18




}
