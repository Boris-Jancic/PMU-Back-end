package com.PMU.Bamboo.repository;

import com.PMU.Bamboo.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<Seller, Long> {
    public Seller findByUserId(Long id);
}
