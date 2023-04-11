package com.example.demo.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderVO {

    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 下单用户ID
     */
    private Long userId;
    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 年龄
     */
    private Integer userAge;
    /**
     * 性别
     */
    private Integer userGender;
}
