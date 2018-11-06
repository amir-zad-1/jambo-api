package com.hypbox.jambo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Resource Not Found!")
public class Http404Exception extends RuntimeException {

    public Http404Exception() {
        super("Resource Not Found!");
    }
}
