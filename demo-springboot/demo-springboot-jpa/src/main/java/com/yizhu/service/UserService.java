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

    public List<User> findAllByUserName(String userName){
        return userRepository.findAllByUserName(userName);
    }

    public User findAllById(int id){
        return userRepository.findAllById(id);
    }

    public List<User> saveUsers(List<User> users){
        List<User> result = userRepository.saveAll(users);
        return result;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
