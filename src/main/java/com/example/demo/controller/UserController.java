package com.example.demo.controller;

import com.example.demo.common.JsonResult;
import com.example.demo.dao.UserDao;
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
    UserDao userDao;


    @GetMapping("")
    public  JsonResult<Object> selectByPage(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                            @RequestParam(name = "pageSize", required = false, defaultValue = "2") Integer pageSize,
                                            @RequestParam(name = "name",required = false) String name){
        return  new JsonResult<>(userService.selectByPage(pageNum,pageSize,name));
    }

    @GetMapping("detail")
        public JsonResult<User> selectById(@RequestParam(name = "id")Integer id){
        return new JsonResult<>(userService.selectById(id));
    }

    @PostMapping("")
    public JsonResult<Map> save(@RequestBody User user){
        userService.save(user);
        return new JsonResult<>(new HashMap<>());
    }

    @PutMapping("")
    public JsonResult<Map> update(@RequestBody User user){
        userService.update(user);
        return new JsonResult<>(new HashMap<>());
    }

    @DeleteMapping("{id}")
        public JsonResult<Map> delete(@PathVariable("id") Integer id){
        userService.deleteById(id);
        return new JsonResult<>(new HashMap<>());
    }
}
