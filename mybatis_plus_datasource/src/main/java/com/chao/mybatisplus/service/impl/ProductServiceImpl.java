package com.chao.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chao.mybatisplus.mapper.ProductMappper;
import com.chao.mybatisplus.pojo.Product;
import com.chao.mybatisplus.service.ProductService;
import org.springframework.stereotype.Service;

@Service
@DS("slave_1")
public class ProductServiceImpl extends ServiceImpl<ProductMappper, Product> implements ProductService {
}
