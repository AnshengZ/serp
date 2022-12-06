package com.tencent.tequila.dao;

import com.tencent.tequila.model.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrandMapper {

    Brand getBrandById(@Param("id") Integer id);

    Brand getBrandByName(@Param("name") String name);

    List<Brand> getBrands();

    void add(Brand brand);

    void update(Brand brand);

    void delete(@Param("id") Integer id);
}
