package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("test")
public class testController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("")
    public Object selectOrders() {
        List<OrderVO> orderVOS = userMapper.selectOrders();
        System.out.println("orderVOS" + orderVOS);
        return orderVOS;
    }

    @GetMapping("page")
    public Object selectOrdersPage() {
        // 查询第一页，每页显示 10 条
        Page<OrderVO> page = new Page<>(1, 10);
        // 注意：一定要手动关闭 SQL 优化，不然查询总数的时候只会查询主表
        page.setOptimizeCountSql(false);
        // 组装查询条件 where age = 20
        QueryWrapper<OrderVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 20);

        IPage<OrderVO> page1 = userMapper.selectOrderPage(page, queryWrapper);

        System.out.println("总记录数：" + page1.getTotal());
        System.out.println("总共多少页：" + page1.getPages());
        System.out.println("当前页码：" + page1.getCurrent());
        System.out.println("查询数据：" + page1.getRecords());
        return page1;
    }

}

