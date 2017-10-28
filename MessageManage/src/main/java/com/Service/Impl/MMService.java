package com.Service.Impl;

import com.Service.IMMService;

import java.util.Map;

/**
 * Created by Zhang on 2017/10/28.
 */
public class MMService extends BaseService implements IMMService {
    @Override
    public void mseeageManage(Map<String, Object> message) {
        saveHistory(message);
    }

    private void saveHistory(Map<String, Object> message) {
        String sender=(String)message.get("sender");
        String sendAddress=(String)message.get("sendAddress");
        String sendCanal=(String)message.get("sendCanal");
        String sendTime=(String)message.get("sender");
        String content=(String)message.get("content");
        String type=(String)message.get("type");
        String addressee=(String)message.get("addressee");
    }
}
