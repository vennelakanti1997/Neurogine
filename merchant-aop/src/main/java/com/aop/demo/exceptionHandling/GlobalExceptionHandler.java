package com.aop.demo.exceptionHandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Customize the response for MethodArgumentNotValidException.
     * <p>This method delegates to {@link #handleExceptionInternal}.
     *
     * @param ex      the exception
     * @param headers the headers to be written to the response
     * @param status  the selected response status
     * @param request the current request
     * @return a {@code ResponseEntity} instance
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        final String message =ex.getAllErrors().get(0).getDefaultMessage();
        return ResponseEntity.badRequest().body(new Error(HttpStatus.BAD_REQUEST.value(), message));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Error> handleBusinessException(final BusinessException exception){
        return ResponseEntity.badRequest().body(new Error(HttpStatus.BAD_REQUEST.value(), exception.getError().getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(final Exception businessException){
    return ResponseEntity.internalServerError().body(new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()));
    }


}
