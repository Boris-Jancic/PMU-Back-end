package com.PMU.Bamboo.repository;

import com.PMU.Bamboo.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepo extends JpaRepository<Article, Long> {
    @Query(value = "SELECT a FROM Article a WHERE a.sellerId = ?1")
    List<Article> getSellerArticles(Long sellerId);
}
