package com.tencent.tequila.service.impl;

import com.tencent.tequila.dao.BrandMapper;
import com.tencent.tequila.dao.ProductMapper;
import com.tencent.tequila.dto.ProductRequest;
import com.tencent.tequila.model.Brand;
import com.tencent.tequila.model.Product;
import com.tencent.tequila.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;

    @Resource
    BrandMapper brandMapper;
    @Override
    public List<Brand> getBrands() {
        return brandMapper.getBrands();
    }

    @Override
    public Brand getBrand(String name) {
        return brandMapper.getBrandByName(name);
    }

    @Override
    public void addBrand(Brand brand) {
        brandMapper.add(brand);
    }

    @Override
    public List<Product> getProducts() {
        return productMapper.getProducts();
    }

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

    @Override
    public List<Product> getProductByParams(ProductRequest request) {
        return productMapper.getProductByParams(request);
    }
}
