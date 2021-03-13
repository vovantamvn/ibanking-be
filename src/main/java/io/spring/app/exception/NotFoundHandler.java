package io.spring.app.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class NotFoundHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = NotFoundException.class)
  public ResponseEntity<Object> handler(RuntimeException exception, WebRequest request) {
    String message = exception.getMessage();
    HttpHeaders headers = new HttpHeaders();
    HttpStatus status = HttpStatus.NOT_FOUND;
    return handleExceptionInternal(exception, message, headers, status, request);
  }
}
