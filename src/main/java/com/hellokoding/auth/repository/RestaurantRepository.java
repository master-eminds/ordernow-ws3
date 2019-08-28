package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.Admin;
import com.hellokoding.auth.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
