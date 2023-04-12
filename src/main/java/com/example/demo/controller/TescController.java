package com.example.demo.controller;

import com.example.demo.common.JsonResult;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping("test")
public class TescController {

    @Value("${web.upload-path}")
    private String uploadPath;

    @GetMapping("treeList")
    public JsonResult<List> treeList(){
        User tree1=new User(1,"aaa",0);
        User tree2=new User(2,"bbb",0);
        User tree3=new User(3,"ccc",0);
        User tree4 = new User();

        List<User> list = Arrays.asList(tree1, tree2, tree3,tree4);
        return new JsonResult<>(200, "获取用户列表成功",list);
    }

    @GetMapping("personList")
    public JsonResult<List> UserList(){
        User User1=new User(1,"aaa",0);
        User User2=new User(2,"bbb",0);
        User User3=new User(3,"ccc",0);
        User User4=new User(4,"ddd",0);
        User User5=new User(5,"eee",0);

        List<User> list = Arrays.asList(User1, User2, User3,User4,User5);
        return new JsonResult<>(200, "获取用户列表成功",list);
    }

    @GetMapping("dogList")
    public JsonResult<List> dogList(){
        User User1=new User(1,"aaa",0);
        User User2=new User(2,"bbb",0);
        User User3=new User(3,"ccc",0);
        User User4=new User(4,"ddd",0);
        User User5=new User(5,"eee",0);

        List<User> list = Arrays.asList(User1, User2, User3,User4,User5);
        return new JsonResult<>(200, "获取用户列表成功",list);
    }

    @GetMapping("tabList1")
    public JsonResult<List> tabList1(){
        User User1=new User(1,"111",0);
        User User2=new User(2,"111",0);
        User User3=new User(3,"111",0);
        User User4=new User(4,"111",0);
        User User5=new User(5,"111",0);

        List<User> list = Arrays.asList(User1, User2, User3,User4,User5);
        return new JsonResult<>(200, "获取用户列表成功",list);
    }

    @GetMapping("tabList2")
    public JsonResult<List> tabList2(){
        User User1=new User(1,"222",0);
        User User2=new User(2,"222",0);
        User User3=new User(3,"222",0);
        User User4=new User(4,"222",0);
        User User5=new User(5,"222",0);

        List<User> list = Arrays.asList(User1, User2, User3,User4,User5);
        return new JsonResult<>(200, "获取用户列表成功",list);
    }

    @GetMapping("tabList3")
    public JsonResult<List> tabList3(){
        User User1=new User(1,"333",0);
        User User2=new User(2,"333",0);
        User User3=new User(3,"333",0);
        User User4=new User(4,"333",0);
        User User5=new User(5,"333",0);

        List<User> list = Arrays.asList(User1, User2, User3,User4,User5);
        return new JsonResult<>(200, "获取用户列表成功",list);
    }

    @PostMapping("upload")
    public String upload(MultipartFile file) throws Exception {
        file.transferTo(new File(uploadPath + file.getOriginalFilename()));
        return "上传成功";
    }

}
