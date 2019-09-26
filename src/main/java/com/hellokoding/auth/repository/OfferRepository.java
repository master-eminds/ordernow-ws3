package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.Category;
import com.hellokoding.auth.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface OfferRepository extends JpaRepository<Offer, Long>{

}
