package com.leothon.bookAppoint.service.impl;


import com.leothon.bookAppoint.dao.AppointmentDAO;
import com.leothon.bookAppoint.dao.BookDAO;
import com.leothon.bookAppoint.dto.AppointExecution;
import com.leothon.bookAppoint.entity.Appointment;
import com.leothon.bookAppoint.entity.Book;
import com.leothon.bookAppoint.enums.AppointStateEnum;
import com.leothon.bookAppoint.exception.AppointException;
import com.leothon.bookAppoint.exception.NoNumberException;
import com.leothon.bookAppoint.exception.RepeatAppointException;
import com.leothon.bookAppoint.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //注入Service依赖
    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private AppointmentDAO appointmentDAO;

    public Book getById(long bookId) {
        return bookDAO.queryById(bookId);
    }

    public List<Book> getListBook() {
        return bookDAO.queryAll(0,1000);
    }

    /**
     * 使用注解控制事务方法的优点：
     * 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     * @param bookId
     * @param studentId
     * @return
     */
    @Transactional
    public AppointExecution appointBook(long bookId, long studentId) {
        try {
            //减库存
            int update = bookDAO.reduceNumber(bookId);
            if (update <= 0){
                throw new NoNumberException("库存不足");
            }else {
                int insert = appointmentDAO.insertAppointment(bookId,studentId);
                if (insert <= 0){
                    throw new RepeatAppointException("重复预约");
                }else {
                    Appointment appointment = appointmentDAO.queryByKeyWithBook(bookId,studentId);
                    return new AppointExecution(bookId, AppointStateEnum.SUCCESS,appointment);
                }
            }
        }catch (NoNumberException e1){
            throw e1;
        }catch (RepeatAppointException e2){
            throw e2;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new AppointException("预约内部错误" + e.getMessage());
        }
    }
}

















