package myshopping.mapper;

import myshopping.entity.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

@Mapper
public interface BrandMapper {
    @Select("SELECT count(*)  FROM xchl_brand")
    int count();
    @Select("select english_name,brand_id from xchl_brand where brand_id = #{brandId}")
    Brand getBrandNameById(Long brandId);
}
