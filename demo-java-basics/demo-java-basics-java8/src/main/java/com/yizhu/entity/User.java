package com.yizhu.entity;

/**
* @author 逸竹
* @Description 用户实体类
* @Date 21:39 2018/8/27
* @Param
* @return
**/
public class User {
    private String name;    // 用户姓名
    private int age;        // 用户年龄
    private String type;    // 用户类型

    public User(){}
    public User(String name, int age, String type){
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                '}';
    }
}
