package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {

  List<Product> getProducts();

  Product getProduct(@Param("id") Integer id);

  Product getProductByCode(@Param("code") String code);

  void upsertProduct(Product product);

  void clearProduct(@Param("id") String code);
}
