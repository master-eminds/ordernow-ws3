package com.hellokoding.auth.service;

import com.hellokoding.auth.model.InfoProduct;
import com.hellokoding.auth.model.Product;
import com.hellokoding.auth.repository.ProdusRepository;
import com.hellokoding.auth.util.CountProdus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ProdusServiceImpl implements ProdusService {

    @Autowired
    ProdusRepository produsRepository;
    @PersistenceContext
    private EntityManager em;
    @Override
    public Product save(Product product) {
        return produsRepository.saveAndFlush(product);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        if(product.getId()!=null){
            produsRepository.delete(product.getId());
        }
            return produsRepository.saveAndFlush(product);
    }


    @Override
    public void delete(Long id) {
        produsRepository.delete(id);
    }

    @Override
    public List<Product> findAll() {
        List produse= em.createNativeQuery(
                "select * from produse where sters=0", Product.class)
                .getResultList();
        return produse;
    }

    @Override
    public List<CountProdus> numarProduseComandate() {


        return em.createNativeQuery(
                "select p.id, denumire, sum(cantitate) as cantitate_totala" +
                        " from itemi_comanda i, produse p where p.id=i.produs_id" +
                        " group by p.id order by cantitate_totala desc limit 6;", CountProdus.class)
                .getResultList();
    }

    @Override
    public Product findById(Long id) {
        return produsRepository.findOne(id);
    }

    @Override
    public List<Product> findAllByVizibilitate(Long categorieId, String vizibilitate) {
        List produse = em.createNativeQuery(
                "select * from produse where categorie_id=:1 and vizibilitate =:2 and sters=0", Product.class)
                .setParameter(1, categorieId)
                .setParameter(2, vizibilitate)
                .getResultList();
        return produse;    }

    @Override
    public List<InfoProduct> findAllByCategorie(Long categorieId) {
        List produse = em.createNativeQuery(
                "select id,name,description,image,price from produse where categorie_id=:1 and active=1", InfoProduct.class)
                .setParameter(1, categorieId)
                .getResultList();
        return produse;
    }

}
