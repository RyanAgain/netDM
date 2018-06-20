package com.datamanager.exception;

/**
 * 2018-05-29-9:26 Author By AgainP
 */
public class UserAuthException extends RuntimeException {

    public UserAuthException(String message) {
        super(message);
    }

    public UserAuthException(String message, Throwable cause) {
        super(message, cause);
    }

}
