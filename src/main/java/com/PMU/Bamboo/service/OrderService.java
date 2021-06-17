package com.PMU.Bamboo.service;

import com.PMU.Bamboo.model.BuyerOrder;
import com.PMU.Bamboo.model.OrderedArticle;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    BuyerOrder saveBuyerOrder(BuyerOrder buyerOrder);
    BuyerOrder findById(Long id);
    Long findLastOrder();
    OrderedArticle saveOrderedArticle(OrderedArticle orderedArticle);
    List<BuyerOrder> getBuyerOrders(String username);
    List<BuyerOrder> getSellerComments(String username);
    Optional<Double> getSellerGrade(String username);
}
