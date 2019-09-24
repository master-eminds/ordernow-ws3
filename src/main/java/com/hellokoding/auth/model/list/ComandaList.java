package com.hellokoding.auth.model.list;

import com.hellokoding.auth.model.Comanda;
import com.hellokoding.auth.model.Masa;
import com.hellokoding.auth.util.BaseModel;

import java.util.List;

public class ComandaList extends BaseModel {

    private List<Comanda> comandaList;

    public List<Comanda> getComandaList() {
        return comandaList;
    }

    public void setComandaList(List<Comanda> comandaList) {
        this.comandaList = comandaList;
    }
}
