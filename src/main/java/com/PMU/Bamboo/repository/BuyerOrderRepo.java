package com.PMU.Bamboo.repository;

import com.PMU.Bamboo.model.Buyer;
import com.PMU.Bamboo.model.BuyerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BuyerOrderRepo extends JpaRepository<BuyerOrder, Long> {
    @Query(value = "SELECT bo FROM BuyerOrder bo WHERE bo.user = ?1 AND bo.delivered = false")
    List<BuyerOrder> findNotDeliveredOrdersByUsername(String username);

    @Query(value = "SELECT bo FROM BuyerOrder bo WHERE bo.delivered = true AND bo.id" +
            " IN (SELECT orderId FROM OrderedArticle WHERE article.id" +
            " IN (SELECT id FROM Article WHERE sellerId" +
            " IN (SELECT id FROM User WHERE username = ?1)))")
    List<BuyerOrder> findSellerComments(String username);

    @Query(value = "SELECT avg(bo.grade) FROM BuyerOrder bo WHERE bo.id" +
            " IN (SELECT orderId FROM OrderedArticle WHERE article.id" +
            " IN (SELECT id FROM Article WHERE sellerId" +
            " IN (SELECT id FROM User WHERE username = ?1))) AND bo.delivered = true")
    Optional<Double> sellerGrade(String username);

    @Query(value = "SELECT bo.id FROM BuyerOrder bo WHERE bo.id IN (SELECT max(id) FROM BuyerOrder ) ")
    Long findLastOrder();
}