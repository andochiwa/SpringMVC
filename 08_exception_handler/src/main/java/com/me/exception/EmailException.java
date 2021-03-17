package com.me.exception;

/**
 * 邮箱有问题时抛出异常
 */
public class EmailException extends MyUserException {
    public EmailException() {
        super();
    }

    public EmailException(String message) {
        super(message);
    }
}
