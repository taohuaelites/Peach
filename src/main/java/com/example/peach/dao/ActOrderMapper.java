package com.example.peach.dao;

import com.example.peach.pojo.ActOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2018/11/17.
 */
@Component
@Mapper
public interface ActOrderMapper {
    ActOrder getActOrder(Integer id);

    int insertActOrder(ActOrder actOrder);

<<<<<<< HEAD
    List<ActOrder> selectActOrderList(Integer activityId);

    int updateActOrder(ActOrder actOrder);
=======
    List<ActOrder> selectActOrderList(String actnature);
>>>>>>> ead560b8456e748583ec8e8b4b62cdfbe8875259
}
