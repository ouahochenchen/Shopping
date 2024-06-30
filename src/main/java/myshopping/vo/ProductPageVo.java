package myshopping.vo;

import lombok.Data;
import myshopping.entity.Product;

import java.io.Serializable;
import java.util.List;
@Data
public class ProductPageVo implements Serializable {
    private List<Product> productList;
    private Integer total;
}
