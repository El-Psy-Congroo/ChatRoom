package com.Controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Zhang on 2017/10/26.
 */
@Component
@RabbitListener(queues = "newMessage")
public class ReceiverController {

    @RabbitHandler
    public void process(Map<String,Object> message) {
        System.out.println("Receiver : " + message);
    }
}
