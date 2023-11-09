package com.ma.service;

import com.ma.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    boolean save(Book book);
    Book getByID(Integer id);
    boolean update(Book book);
    boolean delete(Integer id);
    List<Book> getAll();
}
