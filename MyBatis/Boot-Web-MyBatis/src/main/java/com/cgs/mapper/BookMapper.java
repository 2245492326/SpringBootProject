package com.cgs.mapper;

import com.cgs.pojo.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【tbl_book】的数据库操作Mapper
* @createDate 2022-11-24 11:52:31
* @Entity com.cgs.pojo.Book
*/
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}




