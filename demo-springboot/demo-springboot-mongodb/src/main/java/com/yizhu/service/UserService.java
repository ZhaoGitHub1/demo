package com.yizhu.service;

import com.yizhu.entity.User;
import com.yizhu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getUsers(String name) {
        return userRepository.findByName(name);
    }

    public User queryUser(User user) {
        return userRepository.selectUser(user);
    }

    public List<User> findByNameAndJob(String name, String job) {
        return userRepository.findByNameAndJob(name, job);
    }
}
