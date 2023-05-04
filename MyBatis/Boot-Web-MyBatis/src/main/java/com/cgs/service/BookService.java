package com.cgs.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cgs.pojo.Book;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Administrator
* @description 针对表【tbl_book】的数据库操作Service
* @createDate 2022-11-24 11:52:31
*/
public interface BookService extends IService<Book> {

    Page<Book> getPage(int currentPage, int pageSize,Book book);
}
