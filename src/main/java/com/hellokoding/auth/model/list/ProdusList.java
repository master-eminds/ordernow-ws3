package com.hellokoding.auth.model.list;

import com.hellokoding.auth.model.Ospatar;
import com.hellokoding.auth.model.Produs;
import com.hellokoding.auth.util.BaseModel;

import java.util.List;

public class ProdusList extends BaseModel {

    private List<Produs> produsList;

    public List<Produs> getProdusList() {
        return produsList;
    }

    public void setProdusList(List<Produs> produsList) {
        this.produsList = produsList;
    }
}
