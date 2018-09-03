package com.yizhu.repository;


import com.yizhu .entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User findAllById(int id);

    /**
     * 根据name查询用户信息
     * @param userName
     * @return
     */
    List<User> findAllByUserName(String userName);

    /**
     * 保存多个用户信息
     * @param users
     */
//    int saveAllUsers(List<User> users);

    /**
     * 保存一个用户信息
     * @param user
     * @return
     */
//    int saveUser(User user);
}
