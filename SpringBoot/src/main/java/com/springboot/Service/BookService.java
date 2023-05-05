package com.springboot.Service;

import com.springboot.pojo.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional //事务注解
public interface BookService {

    boolean addBook(Book book);

    boolean deleteBook(Integer bookId);

    boolean updateBook(Book book);

    List<Book> allBook();

    Book idByBook(Integer bookId);
}
