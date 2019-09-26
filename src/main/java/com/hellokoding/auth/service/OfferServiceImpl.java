package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Category;
import com.hellokoding.auth.model.InfoOffer;
import com.hellokoding.auth.model.Offer;
import com.hellokoding.auth.repository.CategorieRepository;
import com.hellokoding.auth.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    OfferRepository offerRepository;
    @PersistenceContext
    private EntityManager em;

    @Override
    public Offer save(Offer offer) {
        return offerRepository.saveAndFlush(offer);

    }

    @Override
    public void delete(Long id) {
        offerRepository.delete(id);
    }

    @Override
    public Offer findById(Long id) {
        return offerRepository.findOne(id);
    }



    @Override
    public List<Offer> findAll() {
        List oferte= em.createNativeQuery(
                "select * from oferte where active=0", Offer.class)
                .getResultList();
        return oferte;
    }

    @Override
    public List<InfoOffer> findAllInfoByMeniuId(Long meniu_id) {
        List oferte = em.createNativeQuery(
                "select * from oferte where meniu_id=:1 and active =0", InfoOffer.class)
                .setParameter(1, meniu_id)
                .getResultList();
        return oferte;   }


}
