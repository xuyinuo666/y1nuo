package com.system.global.exception;

import exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import res.BaseResponse;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionController {
    @ExceptionHandler(BusinessException.class)
    public BaseResponse business(BusinessException businessException){
        return new BaseResponse(businessException.getCode(),businessException.getMsg());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse runtime(RuntimeException businessException){
        log.error("error",businessException.fillInStackTrace());
        log.error("系统错误，{}",businessException.getMessage(),businessException.getCause());
        return new BaseResponse("-1","系统异常！");
    }
}
