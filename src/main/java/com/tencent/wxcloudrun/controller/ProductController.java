package com.tencent.wxcloudrun.controller;


import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.ProductRequest;
import com.tencent.wxcloudrun.model.Brand;
import com.tencent.wxcloudrun.model.Product;
import com.tencent.wxcloudrun.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Resource
    ProductService productService;

    /**
     * 获取
     *
     * @return API response json
     */
    @GetMapping(value = "/pdt/brand")
    ApiResponse getBrand() {
        List<String> names = productService.getBrands().stream().map(Brand::getName).collect(Collectors.toList());
        return ApiResponse.ok(names);
    }

    /**
     * 获取
     *
     * @return API response json
     */
    @GetMapping(value = "/pdt/get/{code}")
    ApiResponse getPdt(@PathVariable String code) {
        Optional<Product> productByCode = productService.getProductByCode(code);
        if (productByCode.isPresent()) {
            return ApiResponse.ok(productByCode.get());
        }
        return ApiResponse.ok(null);
    }

    /**
     * 自增
     *
     * @param request {@link ProductRequest}
     * @return API response json
     */
    @PostMapping(value = "/pdt/add")
    ApiResponse add(@RequestBody ProductRequest request) {
        logger.info("add req:{}", request);
        Optional<Product> productByCode = productService.getProductByCode(request.getCode());
        Integer count = 1;
        if (productByCode.isPresent()) {
            count += productByCode.get().getNum();
        }
        Product pdt = Product.builder()
                .id(request.getId())
                .name(request.getName())
                .code(request.getCode())
                .type(request.getType())
                .info(request.getInfo())
                .num(count)
                .status(1)
                .build();
        productService.upsertProduct(pdt);
        return ApiResponse.ok(0);
    }

    /**
     * 删除
     *
     * @param {@link ProductRequest}
     * @return API response json
     */
    @DeleteMapping(value = "/pdt/del/{code}")
    ApiResponse add(@PathVariable String code) {
        productService.clearProduct(code);
        return ApiResponse.ok(0);
    }
}
