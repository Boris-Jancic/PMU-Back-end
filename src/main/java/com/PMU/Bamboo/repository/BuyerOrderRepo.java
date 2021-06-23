package com.PMU.Bamboo.repository;

import com.PMU.Bamboo.model.BuyerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BuyerOrderRepo extends JpaRepository<BuyerOrder, Long> {
    @Query(value = "SELECT bo FROM BuyerOrder bo WHERE bo.user = ?1 AND bo.delivered = false")
    List<BuyerOrder> findNotDeliveredOrdersByUsername(String username);

//    @Query(value = "SELECT bo FROM BuyerOrder bo WHERE bo.id" +
//            " IN (SELECT o FROM OrderedArticle o WHERE o.article.id" +
//            " IN (SELECT a.id FROM Article a WHERE a.sellerId" +
//            " IN (SELECT s.id FROM Seller s WHERE s.user.id" +
//            " IN (SELECT u.id FROM User u WHERE u.username = ?1)))) AND bo.delivered = true")
//    List<BuyerOrder> findSellerComments(String username);

//    @Query(value = "SELECT avg(bo.grade) FROM BuyerOrder bo WHERE bo.id" +
//            " IN (SELECT o FROM OrderedArticle o WHERE o.article.id" +
//            " IN (SELECT a.id FROM Article a WHERE a.sellerId" +
//            " IN (SELECT s.id FROM Seller s WHERE s.user.id" +
//            " IN (SELECT u.id FROM User u WHERE u.username = ?1)))) AND bo.delivered = true")
//    Optional<Double> sellerGrade(String username);

    @Query(value = "SELECT * FROM buyer_order WHERE buyer_order_id" +
            " IN (SELECT order_id FROM ordered_article o WHERE article_id " +
            " IN (SELECT article_id FROM article WHERE seller_id" +
            " IN (SELECT seller_id FROM seller WHERE user_id" +
            " IN (SELECT user_id FROM user u WHERE username = ?1)))) AND delivered = true", nativeQuery = true)
    List<BuyerOrder> findSellerComments(String username);


    @Query(value = "SELECT avg(grade) FROM buyer_order bo WHERE buyer_order_id" +
            " IN (SELECT order_id FROM ordered_article o WHERE article_id " +
            " IN (SELECT article_id FROM article WHERE seller_id" +
            " IN (SELECT seller_id FROM seller WHERE user_id" +
            " IN (SELECT user_id FROM user u WHERE username = ?1)))) AND delivered = true", nativeQuery = true)
    Optional<Double> sellerGrade(String username);

//    @Query(value = "SELECT * FROM article  WHERE user_id = (select id from user where username = ?1)",
//            nativeQuery = true)
}