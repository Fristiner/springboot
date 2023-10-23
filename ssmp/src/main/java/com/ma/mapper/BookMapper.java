package com.ma.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ma.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/* *
 * @packing com.ma.mapper
 * @author mtc
 * @date 15:14 10 21 15:14
 *
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

    @Select("select * from tb1_book where id = #{id};")
    Book getById(Integer id);
}
