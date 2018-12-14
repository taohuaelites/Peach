package com.example.peach.service.impl;

import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.InterestMapper;
import com.example.peach.dao.UserMapper;
import com.example.peach.pojo.Interest;
import com.example.peach.pojo.User;
import com.example.peach.service.InterestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/12/4.
 */
@Service
public class InterestServiceImpl implements InterestService{

    @Resource
    private InterestMapper interestMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public List<String> selectById(Integer id) {

        Interest interest=interestMapper.selectById(id);
        String rs=interest.getCategory();
        List<String> list= Arrays.asList(rs.split(","));
        return list;
    }

    @Override
    public ServiceResponse selectUserByInterest(int id) {

        List<String> list=selectById(id);
        List<User> users=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            List<User> user1=userMapper.selectUserByInterest(list.get(i));
            if (user1 !=null && user1.size()>0){
                for (int j=0;j<user1.size();j++){
                    users.add(user1.get(j));
                }
            }
        }

        if (users!=null && users.size()>0){
            return ServiceResponse.createBySuccess(users);
        }else {
            return ServiceResponse.createByError("该兴趣没有用户");
        }
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
