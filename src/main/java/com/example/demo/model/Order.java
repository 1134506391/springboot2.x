package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_order")
public class Order {
    @TableId(type= IdType.AUTO)
    private  Long id;
    private Long orderId;

    private Long userId;
    private String goodsName;

    private  String goodsPrice;
}
