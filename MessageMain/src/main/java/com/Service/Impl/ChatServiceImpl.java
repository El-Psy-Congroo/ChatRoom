package com.Service.Impl;

import com.alibaba.fastjson.JSON;
import com.model.ReceiveMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.io.IOException;
import java.util.*;

/**
 * Created by Zhang on 2017/10/24.
 */
@Service
public class ChatServiceImpl extends BaseServiceImpl {
    private static List<String> uuidList=new ArrayList<String>();
    private static Map<String,Session> sessionMap=new HashMap<String, Session>();

    public void onOpen(String loginName, Session session) {
        if (sessionMap.size()>=50){
            sessionMap.remove(uuidList.get(0));
            uuidList.remove(0);
        }else {
            uuidList.add(loginName);
            sessionMap.put(loginName,session);
            redisUtils.set(loginName,new Date());
        }
    }

    public void onMessage(String loginName, String message, Session sendSession) {
        ReceiveMessage receiveMessage= JSON.parseObject(message,ReceiveMessage.class);
        uuidList.remove(loginName);
        uuidList.add(loginName);
        Session receiveSession= sessionMap.get(receiveMessage.getRecipients());
        if (receiveSession!=null){
            try {
                String sendMessage=receiveMessage.getMessage();
                Map<String,Object> sendMap=new HashMap<String, Object>();
                sendMap.put("message",sendMessage);
                rmqSender.sendMessage(sendMap);
                receiveSession.getBasicRemote().sendText(loginName+":"+sendMessage); //回复用户
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void onClose(String loginName) {
        uuidList.remove(loginName);
        sessionMap.remove(loginName);
        redisUtils.remove(loginName);
    }
}
