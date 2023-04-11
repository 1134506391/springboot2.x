package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.OrderVO;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public List<OrderVO> selectOrders() {
        List<OrderVO> orderVOS = orderMapper.selectOrders();
        System.out.println("orderVOS" + orderVOS);
        return orderVOS;
    }

    public Object selectOrderPage() {
        Page<OrderVO> page = new Page<>(1, 10);
        // 注意：一定要手动关闭 SQL 优化，不然查询总数的时候只会查询主表
        page.setOptimizeCountSql(false);
        // 组装查询条件 where age = 20
        QueryWrapper<OrderVO> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 20);

        IPage<OrderVO> page1 = orderMapper.selectOrderPage(page, queryWrapper);

        System.out.println("总记录数：" + page1.getTotal());
        System.out.println("总共多少页：" + page1.getPages());
        System.out.println("当前页码：" + page1.getCurrent());
        System.out.println("查询数据：" + page1.getRecords());
        return page1;
    }

}
