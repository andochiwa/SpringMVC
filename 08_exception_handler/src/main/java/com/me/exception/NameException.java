package com.me.exception;

/**
 * 当用户的姓名有异常时抛出NameException
 */
public class NameException extends MyUserException {
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}
