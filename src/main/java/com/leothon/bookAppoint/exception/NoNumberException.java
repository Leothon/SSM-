package com.leothon.bookAppoint.exception;


/**
 * 无库存异常
 */
public class NoNumberException extends RuntimeException{

    public NoNumberException(String message){
        super(message);
    }

    public NoNumberException(String message,Throwable cause){
        super(message,cause);
    }
}
