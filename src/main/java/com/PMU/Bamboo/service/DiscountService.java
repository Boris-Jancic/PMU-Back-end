package com.PMU.Bamboo.service;

import com.PMU.Bamboo.model.Discount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiscountService {
    Discount save(Discount discount);
    List<Discount> getSellerDiscounts(Long id);
    void deleteDiscount(Long id);
}
