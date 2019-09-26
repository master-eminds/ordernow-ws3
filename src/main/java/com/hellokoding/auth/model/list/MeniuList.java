package com.hellokoding.auth.model.list;

import com.hellokoding.auth.model.Menu;
import com.hellokoding.auth.util.BaseModel;

import java.util.List;

public class MeniuList extends BaseModel {

    private List<Menu> menuList;

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
