package com.datamanager.exception;

/**
 * 2018-05-17-10:29 Author By AgainP
 */
public class NoNumberException extends RuntimeException{

    public NoNumberException(String message){
        super(message);
    }

    public NoNumberException(String message,Throwable cause){
        super(message, cause);
    }

}
