package com.example.peach;

import com.example.peach.dao.UserJPA;
<<<<<<< HEAD
import com.example.peach.pojo.User;
=======
>>>>>>> 3b6aa3d79371f2c648dc57e4fbbfcba963361f62
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

<<<<<<< HEAD
=======

>>>>>>> 3b6aa3d79371f2c648dc57e4fbbfcba963361f62
@RunWith(SpringRunner.class)
@SpringBootTest
public class PeachoneApplicationTests {
    @Resource
    private UserJPA userJPA;
    @Test
    public void contextLoads() {
<<<<<<< HEAD
        User user = new User();
        user.setUserRealname("hu");
        System.out.println(userJPA.save(user).getUserRealname());
=======
        int getrows = userJPA.updateUsersetNickname("胡孝",1);
        if(getrows>0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
>>>>>>> 3b6aa3d79371f2c648dc57e4fbbfcba963361f62
    }

}
