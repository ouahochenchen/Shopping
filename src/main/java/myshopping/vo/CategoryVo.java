package myshopping.vo;

import lombok.Data;
import myshopping.entity.Category;

import java.io.Serializable;
import java.util.List;
@Data
public class CategoryVo implements Serializable {
    private List<Category> categoryList;
    private Integer total;
}
