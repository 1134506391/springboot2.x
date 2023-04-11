package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> selectAll(){
        return userMapper.selectList(null);
    }

    public Object selectByPage(Integer pageNum,Integer pageSize, String name) {
        Map<String,Object> map = new HashMap<String, Object>();

        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();

        lqw.eq(!(name==null||"".equals(name)),User::getName, name);

        Page<User> page = new Page<>(pageNum,pageSize);
        Page<User> pageResult = userMapper.selectPage(page,lqw);

        map.put("pageNum",pageResult.getCurrent());
        map.put("pageSize",pageResult.getSize());
        map.put("pages",pageResult.getPages());
        map.put("total",pageResult.getTotal());
        map.put("data",pageResult.getRecords());
        return map;
    }

    public User selectById(Integer id){
        return userMapper.selectById(id);
    }

    public void save(User user){
        userMapper.insert(user);
    }

    public void update(User user){
        userMapper.updateById(user);
    }

    public void deleteById(Integer id){
        userMapper.deleteById(id);
    }
}
