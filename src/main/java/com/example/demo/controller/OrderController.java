package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.OrderVO;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("")
    public List<OrderVO> selectOrders() {
        return orderService.selectOrders();
    }

    @GetMapping("page")
    public Object selectOrdersPage() {
        return orderService.selectOrderPage();
    }
}
