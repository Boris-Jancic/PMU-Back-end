package com.PMU.Bamboo.repository;

import com.PMU.Bamboo.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SellerRepo extends JpaRepository<Seller, Long> {
    public Seller findByUserId(Long id);
}
