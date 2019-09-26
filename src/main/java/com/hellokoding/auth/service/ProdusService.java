package com.hellokoding.auth.service;

import com.hellokoding.auth.model.InfoProduct;
import com.hellokoding.auth.model.Product;
import com.hellokoding.auth.util.CountProdus;

import java.util.List;

public interface ProdusService {


    Product save(Product product);
    Product saveOrUpdate(Product product);
    void delete(Long id);
    List<Product> findAll();
    List<CountProdus> numarProduseComandate();
    List<Product> findAllByVizibilitate(Long categorieId, String vizibilitate);
    List<InfoProduct> findAllByCategorie(Long categorieId);


    Product findById(Long id);

}
