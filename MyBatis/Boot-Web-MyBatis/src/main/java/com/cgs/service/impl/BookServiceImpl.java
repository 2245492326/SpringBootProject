package com.cgs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cgs.pojo.Book;
import com.cgs.service.BookService;
import com.cgs.mapper.BookMapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【tbl_book】的数据库操作Service实现
* @createDate 2022-11-24 11:52:31
*/
@Service
public class  BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService{
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Page<Book> getPage(int currentPage,int pageSize,Book book){
        LambdaQueryWrapper<Book>wrapper=new LambdaQueryWrapper<>();
        wrapper.like(Strings.isNotBlank(book.getType()),Book::getType,book.getType());
        wrapper.like(Strings.isNotBlank(book.getName()),Book::getName,book.getName());
        wrapper.like(Strings.isNotBlank(book.getDescription()),Book::getDescription,book.getDescription());

        Page<Book> page = new Page<>(currentPage, pageSize);
        bookMapper.selectPage(page,wrapper);
        return page;
    }
}




