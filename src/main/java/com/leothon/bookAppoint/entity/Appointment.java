package com.leothon.bookAppoint.entity;
import java.util.Date;

public class Appointment {

    private long bookId;
    private long studentId;
    private Date appointTime;

    private Book book;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "预约内容:{ 图书ID" + bookId + ", 学生ID" + studentId +", 预约时间" + appointTime + ", 图书信息:" + book + "}";
    }
}
