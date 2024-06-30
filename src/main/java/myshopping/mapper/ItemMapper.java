package myshopping.mapper;

import myshopping.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ItemMapper {
    @Select("select size,item_id,retail_price,sale_price,promotion_sale_price,stock from xchl_item where product_id =#{productId}")
    List<Item> getProductSKUDetail(Long productId);
}
