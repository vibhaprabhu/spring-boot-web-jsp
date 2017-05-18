package com.springboot.dao;

import com.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by prasa on 5/18/2017.
 */
@Repository
public class UserDao {

    @Autowired
    MongoTemplate mongoTemplate;

    public void saveUserDetails(User user) {
        System.out.println("saving details");
        mongoTemplate.save(user);
        System.out.println("saved");
    }

}
