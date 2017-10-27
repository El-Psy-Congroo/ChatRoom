package com.Util;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Zhang on 2017/10/26.
 */
@Component
public class RMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendMessage(Map<String,Object> message) {
        this.rabbitTemplate.convertAndSend("newMessage", message);
    }
}
