package com.yizhu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yizhu.dao.UserRepository;
import com.yizhu.dto.UserQueryByPageDTO;
import com.yizhu.dto.UserQueryDTO;
import com.yizhu.entity.User;
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

    public int saveUsers(List<User> users){
        return userRepository.saveAll(users);
    }

    public int saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public List<User> findAllByAge(Integer age){
        return userRepository.findAllByAge(age);
    }

    public List<User> findUsersBySexAndName(Integer userSex, String name){
        return userRepository.findAllBySexAndName(userSex, name);
    }

    public List<User> findUsersDynamic(UserQueryDTO userQueryDto){
        return userRepository.findUsersDynamic(userQueryDto);
    }

    public Page<User> findUsersByPage(UserQueryByPageDTO userQueryByPageDTO) {
        Page page = new Page(userQueryByPageDTO.getPageNo(), userQueryByPageDTO.getPageSize());
        return userRepository.findUsersByPage(page, userQueryByPageDTO);
    }
}

