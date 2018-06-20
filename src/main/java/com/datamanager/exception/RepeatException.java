package com.datamanager.exception;

/**
 * 2018-05-17-10:31 Author By AgainP
 */
public class RepeatException extends RuntimeException {

    public RepeatException(String message){

        super(message);

    }

    public RepeatException(String message, Throwable cause){

        super(message, cause);

    }
}
