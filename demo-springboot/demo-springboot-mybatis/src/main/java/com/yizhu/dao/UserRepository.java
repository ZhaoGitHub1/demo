package com.yizhu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yizhu.dto.UserInfoDTO;
import com.yizhu.dto.UserQueryByPageDTO;
import com.yizhu.dto.UserQueryDTO;
import com.yizhu.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserRepository extends BaseMapper<User> {

    List<User> findAllByUserName(String userName);

    User findAllById(Long id);

    int saveAll(@Param("users") List<User> users);

    int save(@Param("user") User user);

    List<User> findAll();

    List<User> findAllBySexAndName(Integer userSex, String userName);

    List<User> findUsersDynamic(@Param("userQueryDto") UserQueryDTO userQueryDto);

    Page<User> findUsersByPage(Page page, @Param("userQueryByPageDTO") UserQueryByPageDTO userQueryByPageDTO);

    List<UserInfoDTO> findUserInfoByUserId(@Param("userId") Long userId);
}
