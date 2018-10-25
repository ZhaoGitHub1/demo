package com.yizhu.service;

import com.yizhu.DemoApplication;
import com.yizhu.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUser(){
        System.out.println("查询id为1的用户信息："+userService.findAllById(1L));
        List<User> users = userService.findAllByUserName("李四");
        users.forEach(user -> System.out.println("查询到用户信息："+user));
    }

    @Test
    public void testSaveUser(){
        User user1 = new User("赵六","333333",1);
        User user2 = new User("tom","444444",1);
        User user3 = new User("lily","555555",0);
        List<User> users = new ArrayList<>();
        users.add(user2);
        users.add(user3);

        System.out.println("保存成功！"+userService.saveUser(user1));

        userService.saveUsers(users).forEach(user -> System.out.println("保存成功！"+user));
    }
}
