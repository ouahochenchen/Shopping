package myshopping.vo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
@Data
public class ProductVo implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 商品ID
     */
    private Long productId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 更新时间
     */
    private Integer updateTime;
    /**
     * 品牌ID
     */
    private Long brandId;
    /**
     * 品牌ID
     */
    private String brandName;
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
     * 描述
     */
    private String desc;
    /**
     * 图片路径
     */
    private String imgPath;

    /**
     * 分类ID
     */
    private Long categoryId;


}
