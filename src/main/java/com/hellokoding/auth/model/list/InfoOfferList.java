package com.hellokoding.auth.model.list;

import com.hellokoding.auth.model.InfoCategory;
import com.hellokoding.auth.model.InfoOffer;
import com.hellokoding.auth.util.BaseModel;

import java.util.List;

public class InfoOfferList extends BaseModel {

    private List<InfoOffer> infoOfferList;

    public List<InfoOffer> getInfoOfferList() {
        return infoOfferList;
    }

    public void setInfoOfferList(List<InfoOffer> infoOfferList) {
        this.infoOfferList = infoOfferList;
    }
}
