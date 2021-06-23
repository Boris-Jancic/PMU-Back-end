package com.PMU.Bamboo.service;

import com.PMU.Bamboo.dto.NewArticleDto;
import com.PMU.Bamboo.model.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAll();
    List<Article> getSellerArticles(Long id);
    Article save(Article article);
    void delete(Long id);
    Article one(Long id);
    Article saveNewArticle(NewArticleDto newArticleDto);
}
