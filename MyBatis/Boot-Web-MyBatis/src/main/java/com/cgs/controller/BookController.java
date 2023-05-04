package com.cgs.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cgs.controller.tool.Code;
import com.cgs.controller.tool.Result;
import com.cgs.pojo.Book;
import com.cgs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * 查询-->get
 * 新增-->post
 * 修改-->put
 * 删除-->delete
 */
@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    //添加
    @PostMapping
    public Result postBook(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag ? Code.POST_OK : Code.POST_ERR, flag);
    }

    //删除
    @DeleteMapping("/{bookId}")
    public Result deleteBook(@PathVariable Integer bookId) {
        boolean flag = bookService.removeById(bookId);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    //修改
    @PutMapping
    public Result putBook(@RequestBody Book book) {
        boolean flag = bookService.updateById(book);
        return new Result(flag ? Code.PUT_OK : Code.PUT_ERR, flag);
    }

    //根据id查询
    @GetMapping("/{bookId}")
    public Result getBookById(@PathVariable Integer bookId) {
        Book book = bookService.getById(bookId);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String msg = book != null ? "" : "查询失败, 请重试";
        return new Result(code, book, msg);
    }

    //查询全部
    @GetMapping
    public Result getBookAll() {
        List<Book> books = bookService.list();
        Integer code = books != null ? Code.GET_OK : Code.GET_ERR;
        String msg = books != null ? "" : "查询失败, 请重试";
        return new Result(code, books, msg);
    }

    //分页查询
    @GetMapping("/{currentPage}/{pageSize}")
    private Result getBookPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,Book book){
        Page<Book> page = bookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于总页码值, 那么重新执行查询操作, 使用第一页作为当前页码
        if (currentPage>page.getPages()){
            page=bookService.getPage(1,pageSize,book);
        }
        return new Result(Code.GET_OK, page);
    }


}
