package com.ma.controller;

import com.ma.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* *
 * @packing com.ma.controller
 * @author mtc
 * @date 15:00 10 20 15:00
 *
 */
@RestController
@RequestMapping("/books")
public class BookController {
    // 读取yaml的单一数据

    @Value("${country}")
    private String country1;

    // 直接访问数据
    @Value("${user.name}")
    private String name1;

    @Value("${users[1].age}")
    private String age1;
    // 访问数组中的数据
    @Value("${likes[1]}")
    private String likes;
    @GetMapping
    public String getById(){
        System.out.println("springboot is running...");
        System.out.println(country1);
//        System.out.println(aaa);
        System.out.println(name1);
        System.out.println(likes);
        System.out.println(age1);
        return "springboot is running...";

    }
    @Value("${tempDir}")
    private String temp;

    @GetMapping("/use")
    public String ssss(){
        System.out.println(temp);
        return "dasasddas";
    }
    // 一个把所有属性对象全部加载了
    // 使用自动装配将所有对象放到env中
    @Autowired
    private Environment env;

    @GetMapping("env")
    public String Env(){
        System.out.println(env.getProperty("user.name"));
        System.out.println(env.getProperty("users[0].age"));
        System.out.println(myDataSource);
        System.out.println(myDataSource.getDirver());
        System.out.println(myDataSource.getUrl());
        System.out.println(myDataSource.getPassword());
        return "asdasd";
    }

    @Autowired
    private MyDataSource myDataSource;



}

