package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.entity.OrderVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testGetAll(){
        List<User> list = userMapper.selectList(null);
        System.out.println(list);
    }

    @Autowired
    private OrderMapper orderMapper;

    @Test
    void testSelectOrders() {
        List<OrderVO> orderVOS = orderMapper.selectOrders();
        System.out.println("orderVOS"+orderVOS);
    }

    @Test
    void testSelectOrdersPage() {
        // 查询第一页，每页显示 10 条
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
    }

}
