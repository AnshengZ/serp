package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {

  Product getProduct(@Param("id") Integer id);

  Product getProductByCode(@Param("code") String code);

  void upsertProduct(Product product);

  void clearProduct(@Param("id") String code);
}
