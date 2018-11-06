package com.hypbox.jambo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Dates are not available")
public class NotAvailableException extends RuntimeException {
    public NotAvailableException() {
        super("Dates are not available");
    }
}
