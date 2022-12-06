package com.tencent.tequila.dto;

import lombok.Data;

@Data
public class ProductRequest {

    private Integer id;

    private String brand;

    private String name;

    private String code;

    private String type;

    private String info;
}
