package com.hellokoding.auth.model.list;

import com.hellokoding.auth.model.ItemComanda;
import com.hellokoding.auth.util.BaseModel;

import java.util.List;

public class ItemComandaList extends BaseModel {

    private List<ItemComanda> itemComandaList;

    public List<ItemComanda> getItemComandaList() {
        return itemComandaList;
    }

    public void setItemComandaList(List<ItemComanda> itemComandaList) {
        this.itemComandaList = itemComandaList;
    }
}
