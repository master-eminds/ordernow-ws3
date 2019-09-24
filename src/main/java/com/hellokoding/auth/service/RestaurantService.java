package com.hellokoding.auth.service;

import com.hellokoding.auth.model.InfoRestaurant;
import com.hellokoding.auth.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant save(Restaurant restaurant) throws Exception;
    void saveVoid(Restaurant restaurant) throws Exception;

    Restaurant update(Restaurant restaurant);
    Restaurant findById(Long id);
    List<Restaurant> findAll();
    List<InfoRestaurant> getInfoAllRestaurants();
    void delete(Long id);
}
