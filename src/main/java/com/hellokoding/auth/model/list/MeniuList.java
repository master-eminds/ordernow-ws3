package com.hellokoding.auth.model.list;

import com.hellokoding.auth.model.Meniu;
import com.hellokoding.auth.model.Ospatar;
import com.hellokoding.auth.util.BaseModel;

import java.util.List;

public class MeniuList extends BaseModel {

    private List<Meniu> meniuList;

    public List<Meniu> getMeniuList() {
        return meniuList;
    }

    public void setMeniuList(List<Meniu> meniuList) {
        this.meniuList = meniuList;
    }
}
