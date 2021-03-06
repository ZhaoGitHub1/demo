package com.yizhu.repository;


import com.yizhu .entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @EntityGraph(value = "User.findUsers", type = EntityGraph.EntityGraphType.FETCH)
    User findAllById(Long id);

    /**
     * 根据name查询用户信息
     * @param name
     * @return
     */
    @EntityGraph(value = "User.findUsers", type = EntityGraph.EntityGraphType.FETCH)
    @Query(value = "select * from t_user where user_name = :name", nativeQuery = true)
    List<User> findAllByUserName(@Param("name") String name);

    /**
     * 查询所有用户信息
     * @return
     */
    @Query(value = "from User u")
    List<User> findAll();

    /**
     * 根据年龄查询用户信息
     * @param age
     * @return
     */
    @Query(value = "select * from t_user u where u.user_age = ?1", nativeQuery = true)
    List<User> findAllByAge(Integer age);

    /**
     * 根据用户性别和所属组织名称查询用户信息
     * @param sex
     * @param orgName
     * @return
     */
    @Query(value = "select u from User u left join u.org o where u.sex = :sex and o.orgName = :orgName")
    List<User> findAllBySexAndOrgName(@Param("sex") Integer sex, @Param("orgName") String orgName);

    /**
     * 根据用户名模糊查询
     * @return
     */
    List<User> findAllByNameLike(@Param("name") String name);
}

