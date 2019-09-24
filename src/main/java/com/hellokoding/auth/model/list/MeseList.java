package com.hellokoding.auth.model.list;

import com.hellokoding.auth.model.Masa;
import com.hellokoding.auth.model.Meniu;
import com.hellokoding.auth.util.BaseModel;

import java.util.List;

public class MeseList extends BaseModel {

    private List<Masa> meseList;

    public List<Masa> getMeseList() {
        return meseList;
    }

    public void setMeseList(List<Masa> meseList) {
        this.meseList = meseList;
    }
}
