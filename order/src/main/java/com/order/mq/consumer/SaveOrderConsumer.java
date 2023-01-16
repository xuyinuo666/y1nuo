package com.order.mq.consumer;

import com.order.mq.channel.SaveOrderChannel;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;

import java.io.IOException;

@EnableBinding(SaveOrderChannel.class)
public class SaveOrderConsumer {
    @StreamListener(SaveOrderChannel.SAVE_ORDER_IN)
    public void saveOrderConsumer(Message<String> message,@Header(AmqpHeaders.CHANNEL) Channel channel,@Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag) throws IOException {
        System.out.println(message.getPayload());
        channel.basicAck(deliveryTag,true);
    }
}
