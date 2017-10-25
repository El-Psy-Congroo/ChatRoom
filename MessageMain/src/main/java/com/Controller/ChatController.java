package com.Controller;

import com.Service.Impl.ChatServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by Zhang on 2017/10/24.
 */
@Component
@ServerEndpoint(value="/chatRoom/{loginName}")
public class ChatController {
    private static ChatServiceImpl chatServiceImpl;
    private static ApplicationContext applicationContext;
    public static void setApplicationContext(ApplicationContext context){
        applicationContext=context;
    }


    //连接时执行
    @OnOpen
    public void onOpen(@PathParam("loginName") String loginName,
                       Session session) throws IOException {
        chatServiceImpl=applicationContext.getBean(ChatServiceImpl.class);
        chatServiceImpl.onOpen(loginName,session);
    }

    //收到消息时执行
    @OnMessage
    public void onMessage(@PathParam("loginName") String loginName,
                          String message, Session sendSession) throws IOException {
        chatServiceImpl=applicationContext.getBean(ChatServiceImpl.class);
        chatServiceImpl.onMessage(loginName,message,sendSession);
    }

    //关闭时执行
    @OnClose
    public void onClose(@PathParam("loginName") String loginName){
        chatServiceImpl=applicationContext.getBean(ChatServiceImpl.class);
        chatServiceImpl.onClose(loginName);
    }

    //连接错误时执行
    @OnError
    public void onError(Session session, Throwable error){
        error.printStackTrace();
    }


}
