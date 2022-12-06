package com.tencent.tequila.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    private Integer id;

    private String brand;

    private String code;

    private String name;

    private String type;

    private String info;

    private int num;

    private String time;

    private int status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
