package com.tencent.wxcloudrun.dto;

import lombok.Data;

@Data
public class ProductRequest {

    private String brand;

    private String name;

    private String code;

    private String type;

    private String info;
}
