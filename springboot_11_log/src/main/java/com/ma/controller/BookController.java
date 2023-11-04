package com.ma.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* *
 * @packing com.ma.controller
 * @author mtc
 * @date 13:30 11 04 13:30
 *
 */
// 使用注解加入
@Slf4j
@RestController
@RequestMapping("/books")

public class BookController {
    // 创建记录日志的对象
//    private static  final Logger LOGGER =  LoggerFactory.getLogger(BookController.class);


    @GetMapping
    public String getByID(){
        System.out.println("spring init");
        //
        log.debug("debug ....");
        log.info("info ....");
        log.error("error ....");
        log.warn("warn ....");
        // fatal 灾难性级别 系统
        return "springboot is running ...";

    }
}
