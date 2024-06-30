package com.chen.myshopping.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description 商品
 * @author JSON.CN
 * @date 2024-06-29
 */
@Data
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    private Long id;

    /**
     * 商品ID
     */
    private Long productId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 描述
     */
    private String desc;

    /**
     * 色号
     */
    private String colorCode;

    /**
     * 货号
     */
    private String designerId;

    /**
     * 成分
     */
    private String composition;

    /**
     * 规格
     */
    private String dimension;

    /**
     * 季节
     */
    private String seasonCode;

    /**
     * 商品状态 1：可售 2：不可售
     */
    private Integer status;

    /**
     * 品牌ID
     */
    private Long brandId;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 更新时间
     */
    private Integer updateTime;

    /**
     * 我的商品 1 全部 2 我的
     */
    private Integer mine;

    /**
     * 是否上架 1 上架 2 不上架
     */
    private Integer isAdd;

    /**
     * 添加我的商品时间
     */
    private Integer mineTime;

    /**
     * 吊牌价(EUR)
     */
    private Double retailPrice;

    public Product() {}
}
