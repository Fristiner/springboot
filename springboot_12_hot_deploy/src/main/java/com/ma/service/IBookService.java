package com.ma.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ma.pojo.Book;

/* *
 * @packing com.ma.service
 * @author mtc
 * @date 14:00 10 30 14:00
 *
 */
public interface IBookService  extends IService<Book> {
    IPage<Book> getPage(int currentPage,int pageSize);

    IPage<Book> getPage(int currentPage,int pageSize,Book book);

}
