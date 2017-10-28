package com.dao;

import com.model.MessageHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageHistory record);

    int insertSelective(MessageHistory record);

    MessageHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageHistory record);

    int updateByPrimaryKey(MessageHistory record);
}