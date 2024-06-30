package myshopping.service.impl;

import myshopping.entity.Item;
import myshopping.mapper.ItemMapper;
import myshopping.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;
    @Cacheable(value = "productSKUDetailCache",key = "#productId")
    @Override
    public List<Item> getProductSKUDetail(Long productId) {
        return itemMapper.getProductSKUDetail(productId);
    }
    @CachePut(value = "productSKUDetailCache",key = "#productId")
    @Override
    public List<Item> upDateProductSKUDetailCache(Long productId) {
        return itemMapper.getProductSKUDetail(productId);
    }
}
