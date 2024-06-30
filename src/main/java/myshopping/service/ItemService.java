package myshopping.service;

import myshopping.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> getProductSKUDetail(Long productId);
    public List<Item> upDateProductSKUDetailCache(Long productId);
}
