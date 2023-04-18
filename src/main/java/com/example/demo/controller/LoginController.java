package com.example.demo.controller;

import com.example.demo.util.JSONResult;
import com.example.demo.util.JWTUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("login")
public class LoginController {

    @GetMapping("")
    public JSONResult login(@RequestParam(name = "username",required = false) String username,
                            @RequestParam(name = "password",required = false) String password){

        if(!(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123456"))){
            return JSONResult.errorMsg("账号密码错误");
        }

        String token = JWTUtils.createToken(username.toString());
        Map<String,Object> map = new HashMap<>();
        map.put("token",token);

        return JSONResult.ok(map);
    }
}
