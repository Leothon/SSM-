package com.leothon.bookAppoint.dao;

import com.leothon.bookAppoint.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDAO {


    /**
     * 通过ID查询某书
     * @param id
     * @return
     */
    Book queryById(long id);

    /**
     * 查询所有图书
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return
     */
    List<Book> queryAll(@Param("offset") int offset,@Param("limit") int limit);

    /**
     * 减少馆藏数量
     * @param bookId
     * @return 如果影响行数小于等于1,表示更新的记录行数
     */
    int reduceNumber(long bookId);
}
