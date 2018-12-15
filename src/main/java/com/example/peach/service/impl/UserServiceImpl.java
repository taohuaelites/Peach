package com.example.peach.service.impl;

import com.example.peach.common.Conts;
import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.UserMapper;
import com.example.peach.pojo.User;
import com.example.peach.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 根据openid查询用户
     *
     * @param openid
     * @param type
     * @return
     */
    @Override
    public ServiceResponse<Map> selectByOpenid(String openid, String type) {
        if(openid!=null){
        User user = userMapper.selectByOpenid(openid);
        Map<String, Object> map = new HashMap<>();
        if (type.equals(Conts.OPENID)) {
            if (user != null) {
                map.put("user", user);
                return ServiceResponse.createBySuccess("用户登录成功", map);
            }
            return ServiceResponse.createByError("用户需要注册");
        }
        if (type.equals(Conts.NEWOLD)) {
            if (user.getUserNewold()) {
                return ServiceResponse.createBySuccess("用户是新用户");
            } else {
                return ServiceResponse.createByError("用户是老用户");
            }
        }
        }
        return ServiceResponse.createByError("错误");
    }

    /**
     * 授权成功保存用户数据
     *
     * @param user
     * @return
     */
    @Override
    public ServiceResponse<Map> lognUser(User user) {
        ServiceResponse<Map> response = this.selectByOpenid(user.getOpenid(), Conts.OPENID);
        if (response.isSuccess()) {
            return response;
        }
        int userlogn = userMapper.insertSelective(user);
        Map<String, Object> map = new HashMap<>();
        if (userlogn > 0) {
            map.put("user", user);
            return ServiceResponse.createBySuccess("授权成功", map);

        }
        return ServiceResponse.createByError("授权失败!!");
    }


    /**
     * 根据phone查询user
     *
     * @param phone
     * @return
     */
    @Override
    public ServiceResponse<String> selectPhone(String phone) {
        User user = userMapper.selectByphone(phone);
        if (user != null) {
            return ServiceResponse.createByError("该手机号已经绑定了");
        }
        return ServiceResponse.createBySuccess("√");
    }

    @Override
    public ServiceResponse<String> updateUser(User user) {
        int users = userMapper.updateByPrimaryKeySelective(user);
        if (users > 0) {
            return ServiceResponse.createBySuccess("修改成功");
        }
        return ServiceResponse.createByError("修改失败");
    }

    /**
     * 该买会员修改积分,如果是新用户修改成老用户
     *
     * @param user
     * @return
     */
    @Override
    public ServiceResponse<Integer> updateUnewoldAndUIntegralByOpenid(User user) {
        int getrows = userMapper.updateByPrimaryKeySelective(user);
        if (getrows > 0) {
            return ServiceResponse.createBySuccess("用户信息修改成功");
        } else {
            return ServiceResponse.createByError("用户信息修改失败");
        }
    }
//

    /**
     * 根据openid 查询用户
     *
     * @param openid
     * @return
     */
    @Override
    public User selectByOpenid(String openid) {
        User user = userMapper.selectByOpenid(openid);
        if (user != null) {
            System.out.println("openid:查询成功");
            return user;
        } else {
            System.out.println("没有次用户");
            return user;
        }
    }

    @Override
    public List<User> userList() {
        return userMapper.userList();
    }

    @Override
    public int updateUserPhone(User user) {

        return userMapper.updateUserPhone(user);
    }


}
