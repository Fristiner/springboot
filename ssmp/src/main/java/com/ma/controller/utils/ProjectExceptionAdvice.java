package com.ma.controller.utils;

/* *
 * @packing com.ma.controller.utils
 * @author mtc
 * @date 16:52 10 31 16:52
 *
 */
// 异常处理器

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    // 拦截所有异常信息
    @ExceptionHandler(Exception.class)
    public  R doException(Exception e){
        // 进行处理
//        e.printStackTrace();
        e.printStackTrace();
        return new R(false,"输入出现问题");

    }



}
