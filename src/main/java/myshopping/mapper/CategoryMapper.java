package myshopping.mapper;

import myshopping.entity.Category;
import myshopping.vo.CategoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 查询分类名称
     * @return
     */
    @Select("select category_id,category_name from xchl_category where category_id=#{categoryId}")
    Category getCategory(Long categoryId);
}
