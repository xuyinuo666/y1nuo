package com.order.mq;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class MessageBuildUtil {
    public static Message<?> delayMessage(Object data,Long delayTime){
        return MessageBuilder.withPayload(data).setHeader("x-delay",delayTime).build();
    }
}
