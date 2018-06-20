package com.datamanager.exception;

/**
 * 2018-05-16-18:15 Author By AgainP
 */
public class RentFailException extends RuntimeException{
    public RentFailException(String message){super(message);}

    public RentFailException(String message,Throwable cause){super(message,cause);}
}
