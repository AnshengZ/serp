package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Brand;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Brand> getBrands();

    Brand getBrand(String name);

    void addBrand(Brand brand);

    Optional<Product> getProducts();

    Optional<Product> getProduct(Integer id);

    Optional<Product> getProductByCode(String code);

    void upsertProduct(Product product);

    void clearProduct(String code);
}
