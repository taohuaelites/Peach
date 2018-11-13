package com.example.peach;

import com.example.peach.dao.UserJPA;
import com.example.peach.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeachoneApplicationTests {
    @Resource
    private UserJPA userJPA;
    @Test
    public void contextLoads() {
        User user = new User();
        user.setUserRealname("hu");
        System.out.println(userJPA.save(user).getUserRealname());
    }

}
