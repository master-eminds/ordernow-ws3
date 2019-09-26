package com.hellokoding.auth.model;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

public class InfoRestaurant {

    private Long id;
    private String name;
    private String subTitle;
    private String description;
    private List<Image> images;
    private int onlineOrder;
    private int qrCode;
    private int nrComments;
    private int likes;
    private int meniuId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public int getOnlineOrder() {
        return onlineOrder;
    }

    public void setOnlineOrder(int onlineOrder) {
        this.onlineOrder = onlineOrder;
    }

    public int getQrCode() {
        return qrCode;
    }

    public void setQrCode(int qrCode) {
        this.qrCode = qrCode;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getMeniuId() {
        return meniuId;
    }

    public void setMeniuId(int meniuId) {
        this.meniuId = meniuId;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getNrComments() {
        return nrComments;
    }

    public void setNrComments(int nrComments) {
        this.nrComments = nrComments;
    }
}
