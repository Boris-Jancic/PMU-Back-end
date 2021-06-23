package com.PMU.Bamboo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewArticleDto {
    private String id;
    private String base64Image;
    private String imgName;
    private String name;
    private String description;
    private String price;
    private Long sellerId;
}
