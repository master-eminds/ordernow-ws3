package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Categorie;
import com.hellokoding.auth.model.Comanda;

import java.util.List;

public interface ComandaService {
    List<Comanda> findAll();
    List<Comanda> findAllByIdRestaurant(Long id);
    Comanda save(Comanda comanda);
    Comanda update(Comanda comanda);
    Comanda findById(Long id);
    void delete(Long id);

}
