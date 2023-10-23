package com.TianciTech.controller;

/* *
 * @packing com.TianciTech.controller
 * @author mtc
 * @date 14:52 10 20 14:52
 *
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @ResponseBody
    @RequestMapping("/aa")
    public String sss(){
        System.out.println("hello world");
        return "asdasdas";
    }

}
