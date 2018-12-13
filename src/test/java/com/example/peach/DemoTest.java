package com.example.peach;

import com.example.peach.dao.UserMapper;
import com.example.peach.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/12/1.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test(){

    }
}
