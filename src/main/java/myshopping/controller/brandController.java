package com.chen.myshopping.controller;

import com.chen.myshopping.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class brandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping("/t")
    public int count(){
        return brandService.count();
    }
}
