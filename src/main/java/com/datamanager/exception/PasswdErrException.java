package com.datamanager.exception;

/**
 * 2018-06-10-22:39 Author By AgainP
 */
public class PasswdErrException extends RuntimeException {

    public PasswdErrException(String message){

        super(message);

    }

    public PasswdErrException(String message, Throwable cause){

        super(message, cause);

    }
}
