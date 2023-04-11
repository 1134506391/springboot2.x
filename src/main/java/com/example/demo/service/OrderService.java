package com.example.demo.service;

import com.example.demo.entity.OrderVO;
import com.example.demo.entity.User;

import java.util.List;

public interface OrderService {
    public List<OrderVO> selectOrders();

    public Object selectOrderPage();
}
