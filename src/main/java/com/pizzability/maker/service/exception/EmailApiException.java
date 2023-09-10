package com.pizzability.maker.service.exception;

public class EmailApiException extends RuntimeException {
    public EmailApiException() {
        super("🛑 Error while sending email...");
    }
}
