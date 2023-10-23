package com.ma.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ma.domain.Book;
import org.apache.ibatis.annotations.Mapper;

/* *
 * @packing com.ma.mapper
 * @author mtc
 * @date 14:15 10 21 14:15
 *
 */

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
