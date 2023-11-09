package com.ma.service.impl;

import com.ma.domain.Book;
import com.ma.mapper.BookMapper;
import com.ma.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;


    // 模拟缓存 使用hashmap

    private HashMap<Integer, Book> cache = new HashMap<>();


    @Override
    public boolean save(Book book) {
        int insert = bookMapper.insert(book);
        return insert > 0;
    }

    //    @Override
//    public Book getByID(Integer id) {
//
//        // 如果当前缓存中没有本次要查询的数据，则进行查询，否则直接从缓存中读取一个数据
//        Book book = cache.get(id);
//
//        if (book == null){
//            Book queryBook = bookMapper.selectById(id);
//            cache.put(id,queryBook);
//            System.out.println("从数据库中获取数据");
//            return queryBook;
//        }
//        System.out.println("从缓存中获取数据");
//        return  book;
//    }
    @Override
    // value 缓存保存空间  key 小的名称 需要保障唯一性
    @Cacheable(value = "cacheSpace",key = "#id")
    public Book getByID(Integer id) {
        return bookMapper.selectById(id);
    }

    @Override
    public boolean update(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public List<Book> getAll() {
        return bookMapper.selectList(null);
    }
}
