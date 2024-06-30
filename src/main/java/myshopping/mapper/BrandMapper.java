package com.chen.myshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BrandMapper {
    @Select("SELECT count(*)  FROM xchl_brand")
    int count();
}
