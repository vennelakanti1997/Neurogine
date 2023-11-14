package com.assignment.demo.exceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BusinessException extends RuntimeException{
    private Error error;

}
