package com.chen.myshopping.service.impl;

import com.chen.myshopping.mapper.BrandMapper;
import com.chen.myshopping.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public int count() {
        return brandMapper.count();
    }
}
