package com.yizhu.controller;

import com.alibaba.fastjson.JSON;
import com.yizhu.DemoApplication;
import com.yizhu.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveUser() throws Exception{
        User user1 = User.builder()
                .userName("赵六")
                .userPassword("333333")
                .userSex(1)
                .build();
        User user2 = User.builder()
                .userName("tom")
                .userPassword("444444")
                .userSex(1)
                .build();
        User user3 = User.builder()
                .userName("lily")
                .userPassword("555555")
                .userSex(0)
                .build();
        List<User> users = new ArrayList<>();
        users.add(user2);
        users.add(user3);
        String user1Json = JSON.toJSONString(user1);
        String usersJson = JSON.toJSONString(users);
        System.out.println("user1Json====="+user1Json);
        System.out.println("usersJson====="+usersJson);

        // 模拟浏览器带有json请求数据的post请求
        MvcResult mvcResult1 = mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/saveUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(user1Json)
                ).andReturn();
        System.out.println("http://localhost:8080/saveUser的请求状态："+mvcResult1.getResponse().getStatus());
        System.out.println("请求结果："+mvcResult1.getResponse().getContentAsString());

        MvcResult mvcResult2 = mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/saveAllUsers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(usersJson)
                ).andReturn();
        System.out.println("http://localhost:8080/saveAllUser的请求状态："+mvcResult2.getResponse().getStatus());
        System.out.println("请求结果："+mvcResult2.getResponse().getContentAsString());

        getUserTest("赵六");
        getUserTest("tom");
        getUserTest("lily");
    }

    /**
     * 模拟浏览器带有name参数的get请求
     * @param name
     * @throws Exception
     */
    public void getUserTest(String name) throws Exception{
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/getUserByName")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name",name)
                ).andReturn();
        System.out.println("http://localhost:8080/getUserByName的请求状态："+mvcResult.getResponse().getStatus());
        System.out.println("请求结果："+mvcResult.getResponse().getContentAsString());
    }
}
