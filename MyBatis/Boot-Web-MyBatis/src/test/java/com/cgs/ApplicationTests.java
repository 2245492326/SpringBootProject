package com.cgs;

import com.cgs.mapper.BookMapper;
import com.cgs.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private BookMapper bookMapper;

    @Test
    void contextLoads() {
        Book book = bookMapper.selectById(1);
        System.out.println(book);
    }
    @Test
    void test(){
        Book book = new Book();
        book.setName("测试");
        book.setDescription("测试");
        book.setType("测试");
        bookMapper.insert(book);
    }

}
