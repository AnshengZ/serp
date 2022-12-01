package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.model.Product;

import java.util.Optional;

public interface ProductService {

  Optional<Product> getProduct(Integer id);

  Optional<Product> getProductByCode(String code);

  void upsertProduct(Product product);

  void clearProduct(String code);
}
