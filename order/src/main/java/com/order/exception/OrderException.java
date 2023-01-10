package com.order.exception;

import exception.BusinessException;
import res.ResponseCodeInterface;

public class OrderException extends BusinessException {
    public OrderException(String code, String msg) {
        super(code, msg);
    }

    public OrderException(ResponseCodeInterface responseCodeInterface) {
        super(responseCodeInterface);
    }
}
