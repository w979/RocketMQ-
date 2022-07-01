package com.wry.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <h1>  <h1>
 *
 * @author 魏如元
 * @since 2022/7/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    private Long id;

    private String productName;

    private BigDecimal amount;

    private Date createTime;
}
