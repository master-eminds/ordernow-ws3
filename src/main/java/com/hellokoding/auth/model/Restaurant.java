package com.hellokoding.auth.model;

import com.hellokoding.auth.util.BaseModel;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
@Entity
@Table(name = "restaurante")
public class Restaurant extends BaseModel {

    private Long id;
    private String name;
    private String subTitle;
    private String description;
    private List<Image> images;
    private int onlineOrder;
    private int qrCode;
    private int active;
    private int reviewId;
    private int menuId;

    private List<Admin> admini;
    private List<Ospatar> ospatari;
    private List<Masa> mese;
    private List<Comanda> comenzi;

    @OneToMany(cascade=ALL, mappedBy="restaurant")
    public List<Admin> getAdmini() {
        return admini;
    }

    public void setAdmini(List<Admin> admini) {
        this.admini = admini;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @OneToMany(cascade=ALL, mappedBy="restaurant")
    public List<Ospatar> getOspatari() {
        return ospatari;
    }

    public void setOspatari(List<Ospatar> ospatari) {
        this.ospatari = ospatari;
    }
    @OneToMany(cascade=ALL, mappedBy="restaurant")
    public List<Masa> getMese() {
        return mese;
    }
    @OneToMany(cascade=ALL, mappedBy="restaurant")
    public List<Comanda> getComenzi() {
        return comenzi;
    }

    public void setComenzi(List<Comanda> comenzi) {
        this.comenzi = comenzi;
    }

    public void setMese(List<Masa> mese) {
        this.mese = mese;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @OneToMany(cascade=ALL, mappedBy="restaurant")
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }


}
