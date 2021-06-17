package com.PMU.Bamboo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class OrderedArticleDto {
    private int quantity;
    private long articleId;
}
