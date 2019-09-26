package com.hellokoding.auth.model.list;

import com.hellokoding.auth.model.Category;
import com.hellokoding.auth.model.InfoCategory;
import com.hellokoding.auth.util.BaseModel;

import java.util.List;

public class InfoCategoryList extends BaseModel {

    private List<InfoCategory> infoCategoryList;

    public List<InfoCategory> getInfoCategoryList() {
        return infoCategoryList;
    }

    public void setInfoCategoryList(List<InfoCategory> infoCategoryList) {
        this.infoCategoryList = infoCategoryList;
    }
}
