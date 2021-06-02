package com.PMU.Bamboo.repository;

import com.PMU.Bamboo.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepo  extends JpaRepository<Buyer, Long> {
    public Buyer findByUserId(Long id);
}
