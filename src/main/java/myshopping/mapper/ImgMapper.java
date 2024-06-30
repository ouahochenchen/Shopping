package myshopping.mapper;

import myshopping.entity.Img;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImgMapper {
    @Select("select id,product_id,img_path from xchl_img where product_id=#{productId} limit 1")
    Img getImgByProductId(Long productId);
}
