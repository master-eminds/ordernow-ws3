package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Admin;
import com.hellokoding.auth.model.Restaurant;
import com.hellokoding.auth.repository.AdminRepository;
import com.hellokoding.auth.repository.RestaurantRepository;
import com.hellokoding.auth.repository.RoleRepository;
import com.hellokoding.auth.util.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;


    @Override
    public Restaurant save(Restaurant restaurant) throws Exception {
        return restaurantRepository.saveAndFlush(restaurant);
    }

    @Override
    public void saveVoid(Restaurant restaurant) throws Exception {
        restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        if(restaurant.getId()!=null){
            restaurantRepository.delete(restaurant.getId());
        }

        return  restaurantRepository.saveAndFlush(restaurant);
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurantRepository.findOne(id);
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        restaurantRepository.delete(id);
    }


}
