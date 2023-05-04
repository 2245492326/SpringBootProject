package localhost.controller;

import localhost.Service.BookService;
import localhost.controller.tool.Code;
import localhost.controller.tool.Result;
import localhost.pojo.Book;
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
    BookService bookService;

    //添加
    @PostMapping
    public Result postBook(@RequestBody Book book) {
        boolean flag = bookService.addBook(book);
        return new Result(flag ? Code.POST_OK : Code.POST_ERR, flag);
    }

    //删除
    @DeleteMapping("/{bookId}")
    public Result deleteBook(@PathVariable Integer bookId) {
        boolean flag = bookService.deleteBook(bookId);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    //修改
    @PutMapping
    public Result putBook(@RequestBody Book book) {
        boolean flag = bookService.updateBook(book);
        return new Result(flag ? Code.PUT_OK : Code.PUT_ERR, flag);
    }

    //根据id查询
    @GetMapping("/{bookId}")
    public Result getBookById(@PathVariable Integer bookId) {
        Book book = bookService.idByBook(bookId);
        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String msg = book != null ? "" : "查询失败, 请重试";
        return new Result(code, book, msg);
    }

    //查询全部
    @GetMapping
    public Result getBookAll() {
        List<Book> books = bookService.allBook();
        Integer code = books != null ? Code.GET_OK : Code.GET_ERR;
        String msg = books != null ? "" : "查询失败, 请重试";
        return new Result(code, books, msg);
    }
}
