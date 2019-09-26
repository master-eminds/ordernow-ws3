package com.hellokoding.auth.model.list;

import com.hellokoding.auth.model.Category;
import com.hellokoding.auth.model.Menu;
import com.hellokoding.auth.util.BaseModel;

import java.util.List;

public class CategorieList extends BaseModel {

    private List<Category> categoriesList;

    public List<Category> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<Category> categoriesList) {
        this.categoriesList = categoriesList;
    }
}
