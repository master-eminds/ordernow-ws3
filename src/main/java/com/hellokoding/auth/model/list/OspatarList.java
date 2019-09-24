package com.hellokoding.auth.model.list;

import com.hellokoding.auth.model.InfoRestaurant;
import com.hellokoding.auth.model.Ospatar;
import com.hellokoding.auth.util.BaseModel;

import java.util.List;

public class OspatarList extends BaseModel {

    private List<Ospatar> ospatarList;

    public List<Ospatar> getOspatarList() {
        return ospatarList;
    }

    public void setOspatarList(List<Ospatar> ospatarList) {
        this.ospatarList = ospatarList;
    }
}
