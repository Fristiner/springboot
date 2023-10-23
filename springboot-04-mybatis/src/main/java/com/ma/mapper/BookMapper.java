package com.ma.mapper;

import com.ma.domain.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/* *
 * @packing com.ma.mapper
 * @author mtc
 * @date 14:15 10 21 14:15
 *
 */

@Mapper
public interface BookMapper {

    @Select("select * from tb1_book where id = #{id}")
    Books getById(Integer id);
}
