package com.PMU.Bamboo.web.converter;

import com.PMU.Bamboo.dto.OrderedArticleDto;
import com.PMU.Bamboo.model.OrderedArticle;
import com.PMU.Bamboo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class OrderedArtToOrderedArtDto implements Converter<OrderedArticle, OrderedArticleDto> {

    @Autowired
    private ArticleService articleService;

    @Override
    public OrderedArticleDto convert(OrderedArticle orderedArticle) {
        OrderedArticleDto dto = new OrderedArticleDto();
        dto.setQuantity(orderedArticle.getQuanity());
        dto.setArticleId(orderedArticle.getId());
        return dto;
    }
}