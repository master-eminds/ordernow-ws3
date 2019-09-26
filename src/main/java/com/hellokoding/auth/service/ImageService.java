package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Image;

import java.util.List;

public interface ImageService {

    Image save(Image meniu);

    Image findById(Long id);
    void delete(Long id);
    List<Image> findAll();
    List<Image> findAllByIdRestaurant(Long idRestaurant);

}
