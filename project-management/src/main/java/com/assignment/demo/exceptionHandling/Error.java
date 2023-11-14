package com.assignment.demo.exceptionHandling;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder(value = {"code","message"})
public class Error {
    private int code;
    private String message;
}
