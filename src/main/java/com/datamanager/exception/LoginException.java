package com.datamanager.exception;

/**
 * 2018-06-10-23:20 Author By AgainP
 */
public class LoginException extends RuntimeException {
    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
