package io.spring.app.exception;

public class MyException extends RuntimeException {
    private final String message;

    public MyException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
