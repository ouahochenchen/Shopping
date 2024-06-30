package myshopping.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @description 商品图片
 * @author JSON.CN
 * @date 2024-06-29
 */
@Data
public class Img implements Serializable {

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
     * 图片路径
     */
    private String imgPath;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 更新时间
     */
    private Integer updateTime;

    public Img() {}
}
