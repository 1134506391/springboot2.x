package com.example.demo;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
    }

    @Test
    void testGetAll(){
        List<User> list = userDao.selectList(null);
        System.out.println(list);
    }

}
