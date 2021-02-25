package io.spring.app.exception;

public class NotFoundException extends MyException {

    public NotFoundException() {
        super("Resource not found");
    }
}
