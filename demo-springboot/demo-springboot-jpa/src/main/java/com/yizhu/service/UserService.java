package com.yizhu.service;

import com.yizhu.dto.UserQueryDto;
import com.yizhu.entity.User;
import com.yizhu.repository.UserRepository;
import com.yizhu.repository.UserSpecs;
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

    public User findAllById(Long id){
        return userRepository.findAllById(id);
    }

    public List<User> saveUsers(List<User> users){
        return userRepository.saveAll(users);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public List<User> findAllByAge(Integer age){
        return userRepository.findAllByAge(age);
    }

    public List<User> findUsersBySexAndOrg(Integer userSex, String orgName){
        return userRepository.findAllBySexAndOrgName(userSex, orgName);
    }

    public List<User> findUsersDynamic(UserQueryDto userQueryDto){
        return userRepository.findAll(UserSpecs.listQuerySpec(userQueryDto));
    }
}

