package com.tencent.wxcloudrun.model;

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
public class Brand implements Serializable {

    private Integer id;

    private String name;

    private String url;

    private String info;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
