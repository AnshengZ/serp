package com.tencent.tequila.service;

import com.tencent.tequila.dto.ProductRequest;
import com.tencent.tequila.model.Brand;
import com.tencent.tequila.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Brand> getBrands();

    Brand getBrand(String name);

    void addBrand(Brand brand);

    List<Product> getProducts();

    Optional<Product> getProduct(Integer id);

    Optional<Product> getProductByCode(String code);

    void upsertProduct(Product product);

    void clearProduct(String code);

    List<Product> getProductByParams(ProductRequest request);
}
