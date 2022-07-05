package com.wry.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <h1> 订单实体 <h1>
 *
 * @author 魏如元
 * @since 2022/7/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    /**
     * 订单编号
     */
    private Long orderId;
    /**
     * 操作
     */
    private String desc;
}
