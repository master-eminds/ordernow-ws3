package com.hellokoding.auth.service;

import com.hellokoding.auth.model.InfoRestaurant;
import com.hellokoding.auth.model.Ospatar;
import com.hellokoding.auth.model.Restaurant;
import com.hellokoding.auth.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @PersistenceContext
    private EntityManager em;

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
    public List<InfoRestaurant> getInfoAllRestaurants() {
        List restaurante= em.createNativeQuery(
                "select id, name, description, subtitle, qrCode, meniu_id from restaurante" +
                        " where active=?1",InfoRestaurant.class)
                .setParameter(1,1)
                .getResultList();
        return restaurante;
    }

    @Override
    public void delete(Long id) {
        restaurantRepository.delete(id);
    }


}
