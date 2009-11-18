package com.alibaba.intl.bcds.goldroom.exception;

public class LoginIdDuplicatedException extends RuntimeException {

    private static final long serialVersionUID = 1014559321012502832L;

    public LoginIdDuplicatedException() {
        super();
    }

    public LoginIdDuplicatedException(String message) {
        super(message);
    }

    public LoginIdDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginIdDuplicatedException(Throwable cause) {
        super(cause);
    }
}
