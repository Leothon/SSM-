package test;


import com.leothon.bookAppoint.dto.AppointExecution;
import com.leothon.bookAppoint.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class BookServiceImplTest extends BaseTest{

    @Autowired
    private BookService bookService;

    @Test
    public void testAppointBook() throws Exception{
        long bookId = 1001;
        long studentId = 1235648910L;
        AppointExecution execution = bookService.appointBook(bookId,studentId);
        System.out.println(execution);
    }

}
