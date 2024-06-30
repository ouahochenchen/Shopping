package myshopping.vo;

import lombok.Data;
import myshopping.entity.Item;

import java.io.Serializable;
import java.util.List;
@Data
public class ProductAndItem implements Serializable {
    private ProductVo productVo;
    private List<Item> items;
}
