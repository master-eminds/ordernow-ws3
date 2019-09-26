package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Menu;

import java.util.List;

public interface MeniuService {

    Menu save(Menu menu);

    Menu findById(Long id);
    void delete(Long id);
    List<Menu> findAll();
    Menu findByIdRestaurant(Long idRestaurant);
    List<Menu> findTot();

    List<Menu> findAllByStare(String stare);


}
