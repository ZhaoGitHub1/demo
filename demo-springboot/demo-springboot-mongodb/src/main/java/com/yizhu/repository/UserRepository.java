package com.yizhu.repository;

import com.yizhu.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByName(String name);

    User queryFirstByName(String name);

    @Query(value = "{'name':?0, 'userInfo.job':?1}", fields = "{'id':1, 'name':1, 'userInfo.job':1}")
    List<User> findByNameAndJob(String name, String job);

    User selectUser(User user);

}
