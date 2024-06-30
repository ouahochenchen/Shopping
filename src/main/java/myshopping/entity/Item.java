package com.chen.myshopping.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @description sku表
 * @author JSON.CN
 * @date 2024-06-29
 */
@Data
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;

    /**
     * item_id
     */
    private Long itemId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 尺码
     */
    private String size;

    /**
     * 市场价
     */
    private Double retailPrice;

    /**
     * 销售价
     */
    private Double salePrice;

    /**
     * 活动价
     */
    private Double promotionSalePrice;

    /**
     * 库存数
     */
    private Long stock;

    /**
     * 1可售，2或者null为不可售
     */
    private Integer status;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    public Item() {}
}