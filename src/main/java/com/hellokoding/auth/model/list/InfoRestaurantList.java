package com.hellokoding.auth.model.list;

import com.hellokoding.auth.model.InfoRestaurant;
import com.hellokoding.auth.util.BaseModel;

import java.util.List;

public class InfoRestaurantList extends BaseModel {

    private List<InfoRestaurant> infoRestaurantList;

    public List<InfoRestaurant> getInfoRestaurantList() {
        return infoRestaurantList;
    }

    public void setInfoRestaurantList(List<InfoRestaurant> infoRestaurantList) {
        this.infoRestaurantList = infoRestaurantList;
    }
}
