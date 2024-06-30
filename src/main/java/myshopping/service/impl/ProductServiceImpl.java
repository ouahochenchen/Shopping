package myshopping.service.impl;

import myshopping.entity.Product;
import myshopping.mapper.BrandMapper;
import myshopping.mapper.CategoryMapper;
import myshopping.mapper.ImgMapper;
import myshopping.mapper.ProductMapper;
import myshopping.service.ProductService;
import myshopping.vo.ProductPageVo;
import myshopping.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private BrandMapper brandMapper;
    @Autowired
    private ImgMapper imgMapper;
    @Cacheable(value = "brandNameCache", key = "#brandId")
    public String getBrandNameById(Long brandId) {
        return brandMapper.getBrandNameById(brandId).getEnglishName();
    }
    @Cacheable(value = "ImgUrlCache", key = "#productId")
    public String getImgUrlByPid(Long productId){
        return imgMapper.getImgByProductId(productId).getImgPath();
    }
    @Cacheable(value = "categoryNameCache", key = "#categoryId")
    public String getCategoryName(Long categoryId){
        return categoryMapper.getCategory(categoryId).getCategoryName();
    }
    @CachePut(value = "brandNameCache", key = "#brandId")
    public String updateBrandNameCache(Long brandId) {
        return brandMapper.getBrandNameById(brandId).getEnglishName();
    }
    @Cacheable(value = "ImgUrlCache", key = "#productId")
    public String updateImgUrlCache(Long productId){
        return imgMapper.getImgByProductId(productId).getImgPath();
    }
    @Cacheable(value = "categoryNameCache", key = "#categoryId")
    public String updateCategoryNameCache(Long categoryId){
        return categoryMapper.getCategory(categoryId).getCategoryName();
    }
    @Cacheable(value = "productCache", key = "#size + '-' + #cur")
    public ProductPageVo getProduct(int size, int cur) {
        List<Product> productList = productMapper.getProduct(size, (cur - 1) * size);
        productList = productList.stream().map(x -> {
            x.setBrandName(getBrandNameById(x.getBrandId())); // 使用缓存方法获取brandName
            x.setImgUrl(getImgUrlByPid(x.getProductId()));
            x.setCategoryName(getCategoryName(x.getCategoryId()));
            return x;
        }).collect(Collectors.toList());
        Integer totalSize = productMapper.countTotal();
        if (productList != null && productList.size() > 0 && totalSize > 0) {
            ProductPageVo productPageVo = new ProductPageVo();
            productPageVo.setProductList(productList);
            productPageVo.setTotal(totalSize);
            return productPageVo;
        }
        return null;
    }

    // 更新缓存，当某些条件下需要更新缓存时使用 @CachePut

    @Override
    public ProductPageVo getProductByCondition(Product product, int size, int cur) {
        List<Product> productList = productMapper.getProductByCondition(product,size, (cur-1)*size);
        if(productList==null||productList.size()==0){
            return null;
        }
        productList=productList.stream().map(x->{
            x.setBrandName(getBrandNameById(x.getBrandId()));
            x.setImgUrl(getImgUrlByPid(x.getProductId()));
            x.setCategoryName(getCategoryName(x.getCategoryId()));
            return x;
        }).collect(Collectors.toList());
        Integer totalSize = productMapper.countByCondition(product);
        if(productList!=null&&productList.size()>0&&totalSize>0){
            ProductPageVo productPageVo = new ProductPageVo();
            productPageVo.setProductList(productList);
            productPageVo.setTotal(totalSize);
            return productPageVo;
        }
        return null;
    }

    @Override
    public Boolean addProductToMe(Long id) {
        return productMapper.addToMine(id)==1;
    }

    @Override
    public ProductVo getProductDetail(Long id) {
        Product productDetail = productMapper.getProductDetail(id);
        if(productDetail==null){
            return null;
        }
        ProductVo productVo = new ProductVo();
        productVo.setId(productDetail.getId());
        productVo.setCategoryName(getCategoryName(productDetail.getCategoryId()));
        productVo.setProductId(productDetail.getProductId());
        productVo.setName(productDetail.getName());
        productVo.setCreateTime(productDetail.getCreateTime());
        productVo.setUpdateTime(productDetail.getUpdateTime());
        productVo.setBrandId(productDetail.getBrandId());
        productVo.setBrandName(getBrandNameById(productDetail.getBrandId()));
        productVo.setColorCode(productDetail.getColorCode());
        productVo.setDesignerId(productDetail.getDesignerId());
        productVo.setComposition(productDetail.getComposition());
        productVo.setDimension(productDetail.getDimension());
        productVo.setSeasonCode(productDetail.getSeasonCode());
        productVo.setStatus(productDetail.getStatus());
        productVo.setDesc(productDetail.getDesc());
        productVo.setImgPath(getImgUrlByPid(productDetail.getProductId()));
        return productVo;
    }
}
