package com.leothon.bookAppoint.service;



import com.leothon.bookAppoint.dto.AppointExecution;
import com.leothon.bookAppoint.entity.Book;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 业务接口，站在使用者的角度设计接口
 * 三个方面，方法定义粒度，参数，返回类型
 */
public interface BookService {

    /**
     * 通过ID查询一本书
     * @param bookId
     * @return
     */
    Book getById(long bookId);

    /**
     * 查询所有图书
     * @return
     */
    List<Book> getListBook();

    /**
     * 根据图书ID和学生ID来预约图书
     * @param bookId
     * @param studentId
     * @return
     */
    @ResponseBody
    AppointExecution appointBook(long bookId, long studentId);
}
