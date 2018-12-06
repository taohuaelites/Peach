package com.example.peach.service.impl;

import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.InterestMapper;
import com.example.peach.pojo.Interest;
import com.example.peach.service.InterestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/12/4.
 */
@Service
public class InterestServiceImpl implements InterestService{

    @Resource
    private InterestMapper interestMapper;

    @Override
    public List<String> selectById(int id) {

        Interest interest=interestMapper.selectById(id);
        String rs=interest.getCategory();
        List<String> list= Arrays.asList(rs.split(","));
        return list;

    }

    @Override
    public ServiceResponse updateInterest(Interest interest) {

        int rs = interestMapper.updateInterest(interest);

        if (rs > 0) {
            return ServiceResponse.createBySuccess("修改成功！");
        } else {
            return ServiceResponse.createByError("修改失败！");
        }
    }

    @Override
    public ServiceResponse insertInterest(Interest interest) {

        int rs=interestMapper.insertInterest(interest);
        if (rs>0){
            return ServiceResponse.createBySuccess("添加成功！");
        }else {
            return ServiceResponse.createByError("添加失败！");
        }
    }
}
