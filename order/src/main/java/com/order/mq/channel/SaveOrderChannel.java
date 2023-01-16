package com.order.mq.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface SaveOrderChannel {
    String SAVE_ORDER_OUT= "saveOrderOutput";
    String SAVE_ORDER_IN= "saveOrderInput";

    @Output(SAVE_ORDER_OUT)
    MessageChannel saveOrderOutput();

    @Input(SAVE_ORDER_IN)
    SubscribableChannel saveOrderInput();
}
