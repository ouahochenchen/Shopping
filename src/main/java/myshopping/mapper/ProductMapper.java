package myshopping.mapper;

import myshopping.entity.Category;
import myshopping.entity.Item;
import myshopping.entity.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.data.relational.core.sql.In;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("select id,product_id,designer_id,brand_id,name,category_id,season_code,update_time,create_time from xchl_product where product_id in (select product_id from xchl_item where stock >=1) and status = '1' and mine = '1'"+
    " limit #{size} offset #{offset}")
    List<Product> getProduct(int size, int offset);

    @Select("select count(id) from xchl_product where product_id in (select product_id from xchl_item where stock >=1) and status = '1' and mine = '1'")
    Integer countTotal();
    @Select("<script> select id,product_id,designer_id,brand_id,name,category_id,season_code,update_time,create_time " +
            "from xchl_product p where product_id in (select product_id from xchl_item where stock >=1) and status = '1' and mine = '1'"+
            "<if test='product.name != null'> AND p.name = #{product.name} </if>" +
            "<if test='product.categoryId != null'> AND p.category_id = #{product.categoryId} </if>" +
            "<if test='product.designerId != null'> AND p.designer_id = #{product.designerId} </if>" +
            "<if test='product.brandId != null'> AND p.brand_id = #{product.brandId} </if>" +
            "<if test='product.isAdd != null'> AND p.is_add = #{product.isAdd} </if>" +
            "<if test='product.productId != null'> AND p.product_id = #{product.productId} </if>" +
            " limit #{size} offset #{offset}</script>")
    List<Product> getProductByCondition(@Param("product")Product product, int size, int offset);
    @Select("<script>select count(p.product_id) " +
            "from xchl_product p where product_id in (select product_id from xchl_item where stock >=1) and status = '1' and mine = '1'"+
            "<if test='product.name != null'> AND p.name = #{product.name} </if>" +
            "<if test='product.categoryId != null'> AND p.category_id = #{product.categoryId} </if>" +
            "<if test='product.brandId != null'> AND p.brand_id = #{product.brandId} </if>" +
            "<if test='product.designerId != null'> AND p.designer_id = #{product.designerId} </if>" +
            "<if test='product.isAdd != null'> AND p.is_add = #{product.isAdd} </if>" +
            "<if test='product.productId != null'> AND p.product_id = #{product.productId} </if></script>")
    Integer countByCondition(@Param("product")Product product);

    @Update("update xchl_product set mine='2', mine_time=UNIX_TIMESTAMP() where product_id = #{productId}")
    int addToMine(@Param("productId") Long productId);

    @Select("SELECT id, category_id, product_id, name, create_time, update_time, brand_id, color_code, designer_id, composition, dimension, season_code, `desc` " +
            "FROM xchl_product " +
            "WHERE id = #{id}")
    Product getProductDetail(Long id);


}
