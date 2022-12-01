package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.ProductMapper;
import com.tencent.wxcloudrun.model.Product;
import com.tencent.wxcloudrun.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;

    @Override
    public Optional<Product> getProduct(Integer id) {
        return Optional.ofNullable(productMapper.getProduct(id));
    }

    @Override
    public Optional<Product> getProductByCode(String code) {
        return Optional.ofNullable(productMapper.getProductByCode(code));
    }

    @Override
    public void upsertProduct(Product product) {
        productMapper.upsertProduct(product);
    }

    @Override
    public void clearProduct(String code) {
        productMapper.clearProduct(code);
    }
}
