package com.yizhu.java8.stream;

import com.yizhu.entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author 逸竹
* @Description Streams简单实践
* @Date 20:16 2018/8/26
* @Param
* @return
**/
public class StreamsPractice {

    public static void main(String[] args) {

        // 找出小于18岁、是学生身份的用户、按姓名排序、获取前五名
        List<User> users = new ArrayList<>();
        List<User> students = new ArrayList<>();
        List<String> firstFiveUserNames = new ArrayList<>();
        for(User user: users) {
            if(user.getAge() <= 18) {
                if(user.getType().contains("student")) {
                    students.add(user);
                }
            }
        }
        Collections.sort(students,
                new Comparator<User>() {
                    @Override
                    public int compare(User u1, User u2) {
                        return u1.getName().compareTo(u2.getName());
                    }
                });
        int i = 0;
        for(User u : students ){
            firstFiveUserNames.add(u.getName());
            i++;
            if(i>5) break;
        }


        // java8 Stream实现相同功能
        List<String> firstFiveUserNames2 = users.stream()   // 转换成流
                .filter(u->u.getAge()<=18)                  // 过滤获取年龄小于18的
                .filter(u->u.getType()                      // 过滤获取用户类型为学生的
                        .contains("student"))
                .sorted(Comparator.comparing(User::getName))// 按学生姓名排序
                .map(User::getName)                         // 获取所有符合条件的学生姓名流
                .limit(5)                                   // 取出前五
                .collect(Collectors.toList());              // 转换为list

    }

}
