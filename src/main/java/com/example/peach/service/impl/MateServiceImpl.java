package com.example.peach.service.impl;

import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.MateMapper;
import com.example.peach.pojo.Mate;
import com.example.peach.service.MateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/11/22.
 */
@Service
public class MateServiceImpl implements MateService {
    @Resource
   private  MateMapper mateMapper;

    /**
     * 根据userId查询
     * @param userId
     * @return
     */
    @Override
    public Mate selectByuserId(Integer userId) {
        return mateMapper.selectByuserId( userId);
    }

    /**添加择偶要求
     *
     * @param mate
     * @return
     */
    @Override
    public ServiceResponse<String> insertMate(Mate mate) {
        int insert=  mateMapper.insertMate(mate);
        if (insert>0){
           return ServiceResponse.createBySuccess("添加成功");
        }
        return ServiceResponse.createByError("添加失败");
    }

    /**
     * 根据userId修改
     * @param mate
     * @return
     */
    @Override
    public ServiceResponse<String> updateMate(Mate mate) {
        int update=mateMapper.updateMate(mate);
        if (update>0){
            return ServiceResponse.createBySuccess("修改成功");
        }
        return ServiceResponse.createByError("修改失败");
    }
}
