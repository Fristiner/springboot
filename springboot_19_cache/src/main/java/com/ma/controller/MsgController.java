package com.ma.controller;


import com.ma.domain.Book;
import com.ma.service.BookService;
import com.ma.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    private MsgService msgService;
    @GetMapping("/{tele}")
    public String getByID(@PathVariable("tele") String tele){
        return msgService.get(tele);
    }
    @PostMapping
    public boolean check(String tele,String code){
        return msgService.check(tele,code);
    }
}
