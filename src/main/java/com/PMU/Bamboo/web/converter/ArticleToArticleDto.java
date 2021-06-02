package com.PMU.Bamboo.web.converter.converter;

import com.PMU.Bamboo.dto.ArticleDto;
import com.PMU.Bamboo.model.Article;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ArticleToArticleDto implements Converter<Article, ArticleDto> {
    public ArticleToArticleDto() {
    }

    @Override
    public ArticleDto convert(Article article) {
        ArticleDto dto = new ArticleDto();
        dto.setName(article.getName());
        dto.setDescription(article.getDescription());
        dto.setPrice(article.getPrice());
        return dto;
    }

    public List<ArticleDto> convert(List<Article> articles) {

        List<ArticleDto> retVal = new ArrayList();
        Iterator articleIterator = articles.iterator();

        while(articleIterator.hasNext()) {
            Article a = (Article) articleIterator.next();
            ArticleDto dto = this.convert(a);
            retVal.add(dto);
        }

        return retVal;
    }
}
