package com.example.peach.dao;

import com.example.peach.pojo.Mate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/11/22.
 */
@Component
@Mapper
public interface MateMapper {
    Mate selectByuserId(Integer userId);

    int insertMate(Mate mate);

    int updateMate(Mate mate);
}
