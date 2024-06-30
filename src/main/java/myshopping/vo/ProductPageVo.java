package myshopping.vo;

import lombok.Data;
import myshopping.entity.Product;

import java.io.Serializable;
import java.util.List;
@Data
public class ProductVo implements Serializable {
    private List<Product> productList;
    private Integer total;
}
