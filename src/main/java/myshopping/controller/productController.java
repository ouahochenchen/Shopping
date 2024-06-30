package myshopping.controller;

//import myshopping.redissonService.MyRedisService;
import myshopping.common.ResponseHandler;
import myshopping.entity.Item;
import myshopping.entity.Product;
import myshopping.service.ItemService;
import myshopping.service.ProductService;
import myshopping.vo.ProductAndItem;
import myshopping.vo.ProductPageRequestVo;
import myshopping.vo.ProductPageVo;


import myshopping.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ItemService itemService;

    /**
     * 默认的分页查询
     * @param size
     * @param cur
     * @return
     */
    @GetMapping("product/list")
    public ResponseHandler getProductList(@RequestParam("size") int size, @RequestParam("cur") int cur){
        ProductPageVo product = productService.getProduct(size, cur);
        if(product!=null){
            return ResponseHandler.ok().put("data",product);
        }

        return ResponseHandler.error("没有查找到数据或服务异常！");
    }

    /**
     * 根据表单的输入条件进行分页查询
     * @param productPageVo
     * @return
     */
    @PostMapping("product/listBy")
    public ResponseHandler getProductListBySomething(@RequestBody ProductPageRequestVo productPageVo) {
        ProductPageVo productByCondition = productService.getProductByCondition(productPageVo.getProduct(), productPageVo.getSize(), productPageVo.getCur());

        if(productByCondition!=null){
            return ResponseHandler.ok().put("data",productByCondition);
        }
        return ResponseHandler.error("没有查找到数据或服务异常！");
    }

    /**
     * 添加为我的商品
     * @param product
     * @return
     */
    @PostMapping("product/add")
    public ResponseHandler addToMe(@RequestBody Product product){
        if(productService.addProductToMe(product.getProductId())){
            return ResponseHandler.ok();
        }
        return ResponseHandler.error("失败或服务异常！");
    }

    /**
     * 进入详情页，返回商品详情数据和相关sku的列表数据
     * @param id
     * @param productId
     * @return
     */
    @GetMapping("product/detail")
    public ResponseHandler getProductDetail(@RequestParam("id")Long id, @RequestParam("productId")Long productId){
        ProductVo productDetail = productService.getProductDetail(id);
        List<Item> productSKUDetail = itemService.getProductSKUDetail(productId);
        if(productDetail!=null&&productSKUDetail!=null&&productSKUDetail.size()>0){
            ProductAndItem productAndItem = new ProductAndItem();
            productAndItem.setProductVo(productDetail);
            productAndItem.setItems(productSKUDetail);
            return ResponseHandler.ok().put("data",productAndItem);
        }
        return ResponseHandler.error("没有查找到数据或服务异常！");
    }


}
