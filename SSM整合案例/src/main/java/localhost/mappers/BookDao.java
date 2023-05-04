package localhost.mappers;


import localhost.pojo.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {

    @Insert("insert into t_book values(#{bookId}, #{bookName}, #{price}, #{stock})")
    int addBook(Book book);

    @Delete("delete from t_book where book_id = #{bookId}")
    int deleteBook(Integer bookId);

    @Update("update t_book set book_id=#{bookId}, book_name=#{bookName},price=#{price}, stock=#{stock} where book_id = #{bookId}")
    int updateBook(Book book);

    @Select("select book_id as bookId, book_name as bookName, price, stock from t_book")
    List<Book> allBook();

    @Select("select book_id as bookId, book_name as bookName, price, stock from t_book where book_id = #{bookId}")
    Book idByBook(Integer bookId);
}
