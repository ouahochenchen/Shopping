package myshopping.service;

import myshopping.entity.Product;
import myshopping.vo.ProductPageVo;
import myshopping.vo.ProductVo;

public interface ProductService {
    ProductPageVo getProduct(int size, int cur);
    ProductPageVo getProductByCondition(Product product, int size, int cur);

    Boolean addProductToMe(Long id);

    ProductVo getProductDetail(Long id);
}
