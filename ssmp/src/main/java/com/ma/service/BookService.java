package com.ma.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ma.pojo.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/* *
 * @packing com.ma.service
 * @author mtc
 * @date 13:49 10 30 13:49
 *
 */
@Service
public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();

    IPage<Book> getPage(int currentPage,int pageSize);
}
