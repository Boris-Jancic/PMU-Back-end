package com.PMU.Bamboo.web.converter;

import com.PMU.Bamboo.dto.OrderedArticleDto;
import com.PMU.Bamboo.model.Article;
import com.PMU.Bamboo.model.OrderedArticle;
import com.PMU.Bamboo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderedArtDtoToOrderedArt implements Converter<OrderedArticleDto, OrderedArticle> {

    @Autowired
    private ArticleService articleService;

    @Override
    public OrderedArticle convert(OrderedArticleDto dto) {
        OrderedArticle orderedArticle = new OrderedArticle();
        Optional<Article> article = Optional.ofNullable(articleService.one(dto.getArticleId()));
        if (article.isPresent())
            orderedArticle.setArticle(article.get());
        else
            orderedArticle.setArticle(null);
        orderedArticle.setQuanity(dto.getQuanity());
        return orderedArticle;
    }
}