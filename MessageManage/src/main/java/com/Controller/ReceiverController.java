package com.Controller;

import com.Service.IMMService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Zhang on 2017/10/26.
 */
@Component
@RabbitListener(queues = "newMessage")
public class ReceiverController {
    @Autowired
    IMMService immService;

    @RabbitHandler
    public void process(Map<String,Object> message) {
        immService.mseeageManage(message);
    }
}
