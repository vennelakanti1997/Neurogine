package com.assignment.demo.dto;

import com.assignment.demo.exceptionHandling.Error;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder(value = {"success","message","error"})
public class Response {
    @JsonProperty("success")
    private boolean success;
    public Object message;
    public Error error;
    
}
