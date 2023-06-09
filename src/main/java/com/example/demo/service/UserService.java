package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    public List<User> selectAll();

    public Object selectByPage(Integer pageNum,Integer pageSize, String name);

    public User selectById(Integer id);

    public void save(User user);

    public void update(User user);

    public  void deleteById(Integer id);
}
