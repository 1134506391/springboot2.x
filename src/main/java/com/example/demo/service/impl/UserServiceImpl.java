package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public List<User> selectAll(){
        return userDao.selectList(null);
    }

    public User selectById(Integer id){
        return userDao.selectById(id);
    }

    public void save(User user){
        userDao.insert(user);
    }

    public void update(User user){
        userDao.updateById(user);
    }

    public void deleteById(Integer id){
        userDao.deleteById(id);
    }
}
