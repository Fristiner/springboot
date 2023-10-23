package com.ma.mapper.impl;

import com.ma.mapper.BookMapper;
import org.springframework.stereotype.Repository;

/* *
 * @packing com.ma.mapper.impl
 * @author mtc
 * @date 13:58 10 21 13:58
 *
 */
@Repository
public class BookMapperImpl implements BookMapper {

    @Override
    public void save() {
        System.out.println("bookMapper is running ....");
    }
}
