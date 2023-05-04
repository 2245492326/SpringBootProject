package localhost.Service;

import localhost.pojo.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookService {

    boolean addBook(Book book);

    boolean deleteBook(Integer bookId);

    boolean updateBook(Book book);

    List<Book> allBook();

    Book idByBook(Integer bookId);
}
