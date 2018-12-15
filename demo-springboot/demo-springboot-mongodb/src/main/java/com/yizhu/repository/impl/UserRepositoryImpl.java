package com.yizhu.repository.impl;


import com.yizhu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User selectUser(User user){
        Query query = new Query(Criteria
                .where("name").is(user.getName())
                .and("sex").is(user.getSex())
                .and("userInfo.age").is(user.getUserInfo().getAge())
                .and("userInfo.job").is(user.getUserInfo().getJob())
        );

        return mongoTemplate.findOne(query, User.class);
    }
}
