package test;


import com.leothon.bookAppoint.dao.BookDAO;
import com.leothon.bookAppoint.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookDAOTest extends BaseTest {

    @Autowired
    private BookDAO bookDAO;

    @Test
    public void testQueryById() throws Exception{
        long bookId = 1000;
        Book book = bookDAO.queryById(bookId);
        System.out.println(book);
    }

    @Test
    public void testQueryAll() throws Exception{
        List<Book> books = bookDAO.queryAll(0,4);
        for (Book book : books){
            System.out.println(book);
        }
    }

    @Test
    public void testReduceNumber() throws Exception{
        long bookId = 1000;
        int update = bookDAO.reduceNumber(bookId);
        System.out.println("update=" + update);
    }
}
