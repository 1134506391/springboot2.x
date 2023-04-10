package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.JsonResult;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController()
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;



    @GetMapping("")
    public JsonResult<Map> selectAllByPage(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                      @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize,
                                      @RequestParam(name = "name",required = false) String name){
        Map<String,Object> map = new HashMap<String, Object>();

        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.eq(null != name,User::getName, name);

        Page<User> page = new Page<>(pageNum,pageSize);
        Page<User> pageResult = userDao.selectPage(page,lqw);

        map.put("pageNum",pageResult.getCurrent());
        map.put("pageSize",pageResult.getSize());
        map.put("pages",pageResult.getPages());
        map.put("total",pageResult.getTotal());
        map.put("data",pageResult.getRecords());


        return new JsonResult<>(map);
    }

    @GetMapping("detail")
        public User selectById(@RequestParam(name = "id")Integer id){
        return userService.selectById(id);
    }

    @PostMapping("")
    public String save(@RequestBody User user){
        userService.save(user);
        return "ok";
    }

    @PutMapping("")
    public String update(@RequestBody User user){
        userService.update(user);
        return "ok";
    }

    @DeleteMapping("{id}")
        public String delete(@PathVariable("id") Integer id){
        System.out.println("id"+id);
        userService.deleteById(id);
        return "ok";
    }
}
