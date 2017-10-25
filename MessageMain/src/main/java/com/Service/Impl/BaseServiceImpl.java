package com.Service.Impl;

import com.Util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Zhang on 2017/10/25.
 */
public class BaseServiceImpl {
    @Autowired
    RedisUtils redisUtils;
}
