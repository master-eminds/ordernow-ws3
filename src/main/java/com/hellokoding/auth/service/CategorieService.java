package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Category;
import com.hellokoding.auth.model.InfoCategory;

import java.util.List;

public interface CategorieService {

    Category save(Category category);
    void delete(Long id);
    void stergeCategorie(Long id);
    Category findById(Long id);
    List<Category> findAll();

    List<InfoCategory> findAllInfoByMeniuId(Long meniu_id);

    }
