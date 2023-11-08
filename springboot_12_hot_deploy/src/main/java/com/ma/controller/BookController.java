package com.ma.controller;

/* *
 * @packing com.ma.controller
 * @author mtc
 * @date 16:20 10 31 16:20
 *
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ma.controller.utils.R;
import com.ma.pojo.Book;
import com.ma.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
//        return new R(bookService.save(book));
        if (book.getName().equals("123")) throw new IOException();
        Boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book) {
//        return new R(bookService.update(book,null));
//        if (book.getName().equals("123") ) throw new IOException();
        boolean flag = bookService.updateById(book);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable("id") Integer id) {
        return new R(true, bookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getByID(@PathVariable("id") Integer id) {
        System.out.println("test hot deploy ....");
        System.out.println("test hot deploy ....");

        R r = new R(true);
        r.setData(bookService.getById(id));
        return r;
    }
    

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable(required = false) int currentPage,
                     @PathVariable(required = false) int pageSize,
                     Book book) {
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);

        if (currentPage > page.getPages()) {
            page = bookService.getPage((int) page.getPages(), pageSize, book);
        }

        return new R(true, page);
    }


}
