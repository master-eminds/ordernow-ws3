package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Menu;
import com.hellokoding.auth.repository.MeniuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class MeniuServiceImpl implements MeniuService {

    @Autowired
    MeniuRepository meniuRepository;
    @PersistenceContext
    private EntityManager em;

    @Override
    public Menu save(Menu menu) {
        return meniuRepository.saveAndFlush(menu);
    }

    @Override
    public Menu findById(Long id) {
        return meniuRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        meniuRepository.delete(id);
    }

    @Override
    public List<Menu> findTot() {
        return meniuRepository.findAll();
    }
    @Override
    public List<Menu> findAll() {
        List meniuri= em.createNativeQuery(
                "select * from meniuri where sters=0", Menu.class)
                .getResultList();
        return meniuri;
    }

    @Override
    public Menu findByIdRestaurant(Long idRestaurant) {
        Object meniu = em.createNativeQuery(
                "select * from meniuri where restaurant_id=:1 and active=0", Menu.class)
                .setParameter(1 ,idRestaurant)
                .getSingleResult();
        return (Menu) meniu;
    }

    @Override
    public List<Menu> findAllByStare(String stare) {
        List meniuri = em.createNativeQuery(
                "select * from meniuri where stare=:1 and active=0", Menu.class)
                .setParameter(1, stare)
                .getResultList();
        return meniuri;    }
}
