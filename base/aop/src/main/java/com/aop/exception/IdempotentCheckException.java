package com.aop.exception;

public class IdempotentCheckException extends RuntimeException{
    public IdempotentCheckException(String message) {
        super(message);
    }
}
