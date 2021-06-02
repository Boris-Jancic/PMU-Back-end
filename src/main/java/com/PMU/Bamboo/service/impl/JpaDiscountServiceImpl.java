package com.PMU.Bamboo.service.impl;

import com.PMU.Bamboo.model.Discount;
import com.PMU.Bamboo.repository.DiscountRepo;
import com.PMU.Bamboo.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaDiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepo discountRepo;

    @Override
    public Discount save(Discount discount) {
        return discountRepo.save(discount);
    }

    @Override
    public List<Discount> getSellerDiscounts(Long id) {
        return discountRepo.getActualDiscounts(id);
    }

    @Override
    public void deleteDiscount(Long id) {
        discountRepo.deleteById(id);
    }
}
