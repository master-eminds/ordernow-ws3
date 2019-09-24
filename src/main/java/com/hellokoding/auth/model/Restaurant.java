package com.hellokoding.auth.model;

import com.hellokoding.auth.util.BaseModel;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
@Entity
@Table(name = "restaurante")
public class Restaurant extends BaseModel {

    private Long id;
    private String denumire;
    private String descriere;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(length=100000)
    private byte[] imagine;
    private int comandaOnline;
    private int barCode;
    private int activ;
    private List<Admin> admini;
    private List<Meniu> meniuri;
    private List<Ospatar> ospatari;
    private List<Masa> mese;

    @OneToMany(cascade=ALL, mappedBy="restaurant")
    public List<Admin> getAdmini() {
        return admini;
    }

    public void setAdmini(List<Admin> admini) {
        this.admini = admini;
    }
    @OneToMany(cascade=ALL, mappedBy="restaurant")
    public List<Meniu> getMeniuri() {
        return meniuri;
    }

    public void setMeniuri(List<Meniu> meniuri) {
        this.meniuri = meniuri;
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

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public byte[] getImagine() {
        return imagine;
    }

    public void setImagine(byte[] imagine) {
        this.imagine = imagine;
    }

    public int getComandaOnline() {
        return comandaOnline;
    }

    public void setComandaOnline(int comandaOnline) {
        this.comandaOnline = comandaOnline;
    }

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public int getActiv() {
        return activ;
    }

    public void setActiv(int activ) {
        this.activ = activ;
    }
}
