package com.hellokoding.auth.model.list;

import com.hellokoding.auth.model.InfoOffer;
import com.hellokoding.auth.model.InfoProduct;
import com.hellokoding.auth.util.BaseModel;

import java.util.List;

public class InfoProductList extends BaseModel {

    private List<InfoProduct> infoProductList;

    public List<InfoProduct> getInfoProductList() {
        return infoProductList;
    }

    public void setInfoProductList(List<InfoProduct> infoProductList) {
        this.infoProductList = infoProductList;
    }
}
