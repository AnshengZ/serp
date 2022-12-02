package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Brand;
import com.tencent.wxcloudrun.model.Counter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BrandMapper {

    Brand getBrandById(@Param("id") Integer id);

    Brand getBrandByName(@Param("id") String name);

    List<Brand> getBrands();

    void add(Brand brand);

    void update(Brand brand);

    void delete(@Param("id") Integer id);
}
