package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Category;
import com.hellokoding.auth.model.InfoOffer;
import com.hellokoding.auth.model.Offer;

import java.util.List;

public interface OfferService {

    Offer save(Offer offer);
    void delete(Long id);
    Offer findById(Long id);
    List<Offer> findAll();

    List<InfoOffer> findAllInfoByMeniuId(Long meniu_id);

    }
