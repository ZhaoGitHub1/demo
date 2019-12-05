package com.yizhu.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yizhu.dto.UserQueryByPageDTO;
import com.yizhu.dto.UserQueryDTO;
import com.yizhu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserRepository {

    /**
     * 根据用户名称查询所有用户
     * @param userName
     * @return
     */
    List<User> findAllByUserName(String userName);

    User findAllById(Long id);

    int saveAll(@Param("users") List<User> users);

    int save(@Param("users") User user);

    List<User> findAll();

    List<User> findAllByAge(Integer age);

    List<User> findAllBySexAndOrgName(Integer userSex, String orgName);

    List<User> findUsersDynamic(@Param("userQueryDto") UserQueryDTO userQueryDto);

    Page<User> findUsersByPage(Page page, @Param("userQueryDto") UserQueryByPageDTO userQueryByPageDTO);
}
