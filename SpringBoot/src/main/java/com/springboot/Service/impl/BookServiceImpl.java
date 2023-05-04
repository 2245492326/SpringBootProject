package com.springboot.Service.impl;


import com.springboot.Service.BookService;
import com.springboot.mappers.BookDao;
import com.springboot.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean addBook(Book book) {
        int count = bookDao.addBook(book);
        return count > 0;
    }

    @Override
    public boolean deleteBook(Integer bookId) {
        int count = bookDao.deleteBook(bookId);
        return count > 0;
    }


    @Override
    public boolean updateBook(Book book) {
        int count = bookDao.updateBook(book);
        return count > 0;
    }

    @Override
    public List<Book> allBook() {
        List<Book> bookList = bookDao.allBook();
        return bookList;
    }

    @Override
    public Book idByBook(Integer bookId) {
        Book book = bookDao.idByBook(bookId);
        return book;
    }
}
