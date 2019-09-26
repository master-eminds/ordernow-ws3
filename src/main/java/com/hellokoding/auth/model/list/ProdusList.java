package com.hellokoding.auth.model.list;

import com.hellokoding.auth.model.Product;
import com.hellokoding.auth.util.BaseModel;

import java.util.List;

public class ProdusList extends BaseModel {

    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
