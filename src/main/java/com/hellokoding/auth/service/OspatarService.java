package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Admin;
import com.hellokoding.auth.model.Ospatar;

import java.util.List;

public interface OspatarService {
    Ospatar save(Ospatar ospatar);

    Ospatar findById(Long id);

    Ospatar findByEmail(String email);
    void update(Ospatar ospatar);
    List<Ospatar> findAll();
    List<Ospatar>  findAllNestersi();
    List<Ospatar> findAllByIdRestaurant(Long id);
    void delete(Long id);
}
