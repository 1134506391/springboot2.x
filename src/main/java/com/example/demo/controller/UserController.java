package com.example.demo.controller;

import com.example.demo.util.JSONResult;
import com.example.demo.mapper.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;


    @GetMapping("")
    public JSONResult selectByPage(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                           @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize,
                                           @RequestParam(name = "name",required = false) String name){
//        return  new JSONResult<>(userService.selectByPage(pageNum,pageSize,name));
        return JSONResult.ok(userService.selectByPage(pageNum,pageSize,name));
    }

    @GetMapping("detail")
        public JSONResult selectById(@RequestParam(name = "id")Integer id){
        return JSONResult.ok(userService.selectById(id));
    }

    @PostMapping("")
    public JSONResult save(@RequestBody User user){
        userService.save(user);
        return JSONResult.ok();
    }

    @PutMapping("")
    public JSONResult update(@RequestBody User user){
        userService.update(user);
        return JSONResult.ok();
    }

    @DeleteMapping("{id}")
        public JSONResult delete(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return JSONResult.ok();
    }
}
