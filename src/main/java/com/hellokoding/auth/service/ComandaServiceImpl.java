package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Comanda;
import com.hellokoding.auth.model.Masa;
import com.hellokoding.auth.model.Restaurant;
import com.hellokoding.auth.repository.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
public class ComandaServiceImpl implements ComandaService {

    @Autowired
    ComandaRepository comandaRepository;
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Comanda> findAll() {
        return comandaRepository.findAll();
    }

    @Override
    public List<Comanda> findAllByIdRestaurant(Long id) {
        List comenzi = em.createNativeQuery(
                "select * from comenzi where restaurant_id=:1", Comanda.class)
                .setParameter(1, id)
                .getResultList();
        return comenzi;
    }

    @Override
    public Comanda save(Comanda comanda) {
        return comandaRepository.saveAndFlush(comanda);
    }

    @Override
    public Comanda update(Comanda comanda) {

        if (comanda.getId() != null) {
            comandaRepository.delete(comanda.getId());
        }

        return comandaRepository.saveAndFlush(comanda);
    }

    @Override
    public Comanda findById(Long id) {
        return comandaRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        comandaRepository.delete(id);
    }
}
