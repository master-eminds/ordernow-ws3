package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Category;
import com.hellokoding.auth.model.InfoCategory;
import com.hellokoding.auth.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    CategorieRepository categorieRepository;
    @PersistenceContext
    private EntityManager em;

    @Override
    public Category save(Category category) {
        return categorieRepository.saveAndFlush(category);

    }

    @Override
    public void delete(Long id) {
        categorieRepository.delete(id);
    }

    @Override
    public void stergeCategorie(Long id) {
            em.createNativeQuery(
                    "UPDATE categorii m set sters=?1 where m.id= ?2")
                    .setParameter(1, "true")
                    .setParameter(2,id)
                    .executeUpdate();

    }

    @Override
    public Category findById(Long id) {
        return categorieRepository.findOne(id);
    }



    @Override
    public List<Category> findAll() {
        List categorii= em.createNativeQuery(
                "select * from categorii where active=0", Category.class)
                .getResultList();
        return categorii;
    }

    @Override
    public List<InfoCategory> findAllInfoByMeniuId(Long meniu_id) {
        List categorie = em.createNativeQuery(
                "select id,name,description,image from categorii where meniu_id=:1 and active =0", InfoCategory.class)
                .setParameter(1, meniu_id)
                .getResultList();
        return categorie;   }


}
