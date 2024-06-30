package myshopping.vo;

import lombok.Data;
import myshopping.entity.Product;

import java.io.Serializable;

@Data
public class ProductPageVo implements Serializable {
    private Product product;
    private Integer size;
    private Integer cur;
}
