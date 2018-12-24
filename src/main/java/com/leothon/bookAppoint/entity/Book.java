package com.leothon.bookAppoint.entity;

public class Book {
    private long bookId;
    private String name;
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "输出内容:{ 图书ID" + bookId + ", 图书名字" + name +", 馆藏数量" + number + "}";
    }
}
