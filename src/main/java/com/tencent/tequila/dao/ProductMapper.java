package com.tencent.tequila.dao;

import com.tencent.tequila.dto.ProductRequest;
import com.tencent.tequila.model.Product;
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

  List<Product> getProductByParams(ProductRequest request);
}
