package com.example.peach;

import com.example.peach.dao.UserJPA;
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
        int getrows = userJPA.updateUsersetNickname("胡孝",1);
        if(getrows>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

}
