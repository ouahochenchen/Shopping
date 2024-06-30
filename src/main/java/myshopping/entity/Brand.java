package myshopping.entity;

import lombok.Data;

import java.io.Serializable;


/**
 * Auto-generated: 2024-06-29 19:10:18
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键id
     */
    private Long id;

    /**
     * 品牌ID
     */
    private Long brandId;

    /**
     * 品牌名称
     */
    private String englishName;

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

    public Brand() {}
}