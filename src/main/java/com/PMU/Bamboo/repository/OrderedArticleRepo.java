package com.PMU.Bamboo.repository;

import com.PMU.Bamboo.model.OrderedArticle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedArticleRepo extends JpaRepository<OrderedArticle, Long> {

}