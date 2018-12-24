package com.leothon.bookAppoint.exception;

/**
 * 预约未知异常
 */
public class AppointException extends RuntimeException{

    public AppointException(String message){
        super(message);
    }

    public AppointException(String message,Throwable cause){
        super(message,cause);
    }
}
