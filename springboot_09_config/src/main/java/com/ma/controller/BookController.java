package com.ma.controller;

/* *
 * @packing com.ma.controller
 * @author mtc
 * @date 12:13 11 04 12:13
 *
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {
    @GetMapping("test")
    public String getBook(){

        return "springboot init is work";
    }

}
