package com.ma.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ma.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Scanner;

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
        Book book1 = bookMapper.selectById(1);
        System.out.println(book1);
    }
    @Test
    void testInsert()
    {
        Book book = new Book();
        book.setDescription("yibenhaoshu");
        book.setName("哈利波特");
        book.setType("读书的世界");
        int insert = bookMapper.insert(book);
        System.out.println(insert);
    }
    // 分页查询
    @Test
    void testPage()
    {
        IPage page = new Page(2,5);
        IPage page1 = bookMapper.selectPage(page, null);
        System.out.println(page1.getCurrent()); // 当前页数
        System.out.println(page1.getSize());  // size 查询数量
        System.out.println(page1.getCurrent());  // 现在第几页
        System.out.println(page1.getTotal());  //查询的总数据数
        System.out.println(page1.getRecords()); // 查询的数据
        List<Book> records = page1.getRecords();
        for(Book book : records){
            System.out.println(book);
        }
    }
    // 按照条件查询
    @Test
    void testGetBy(){
        QueryWrapper<Book> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.like("name","喜羊羊");
        List<Book> books = bookMapper.selectList(objectQueryWrapper);
        System.out.println(books);
    }

    @Test
    void testGetBy02()
    {
        String name =null;
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
        // 不用写属性名的方法
        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        bookLambdaQueryWrapper.like(name != null,Book::getName,"xiyanyang");
//        if (name != nill)

        List<Book> books = bookMapper.selectList(bookLambdaQueryWrapper);
        System.out.println(books);
    }

}
