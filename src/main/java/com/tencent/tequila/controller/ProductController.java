package com.tencent.tequila.controller;


import com.tencent.tequila.config.ApiResponse;
import com.tencent.tequila.dto.ProductRequest;
import com.tencent.tequila.model.Brand;
import com.tencent.tequila.model.Product;
import com.tencent.tequila.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    @GetMapping(value = "/pdt/get")
    ApiResponse getPdt() {
        List<Product> products = productService.getProducts();
        return ApiResponse.ok(products);
    }
    /**
     * 获取
     *
     * @return API response json
     */
    @PostMapping(value = "/pdt/get")
    ApiResponse getPdt(@RequestBody ProductRequest request) {
        List<Product> products = productService.getProductByParams(request);
        return  ApiResponse.ok(products);
    }
    /**
     * 获取
     *
     * @return API response json
     */
    @GetMapping(value = "/pdt/get/{code}")
    ApiResponse getPdt(@PathVariable String code) {
        Optional<Product> productByCode = productService.getProductByCode(code);
        return productByCode.map(ApiResponse::ok).orElseGet(() -> ApiResponse.ok(null));
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
        Brand brand = productService.getBrand(request.getBrand());
        if (brand == null) {
            Brand bd = Brand.builder().name(request.getBrand()).build();
            productService.addBrand(bd);
        }
        Optional<Product> productByCode = productService.getProductByCode(request.getCode());
        Integer count = 1;
        if (productByCode.isPresent()) {
            count += productByCode.get().getNum();
        }
        Product pdt = Product.builder()
                .id(request.getId())
                .brand(request.getBrand())
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
