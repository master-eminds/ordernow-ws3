package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.Admin;
import com.hellokoding.auth.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE restaurante  set activ=0 where id= ?1",
            nativeQuery = true)
    void deleteProdus(Long id);
}
