package com.PMU.Bamboo.service;

import com.PMU.Bamboo.model.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAll();
    List<Article> getSellerArticles(Long id);
    Article save(Article article);
    Article delete(Long id);
    Article one(Long id);
}
