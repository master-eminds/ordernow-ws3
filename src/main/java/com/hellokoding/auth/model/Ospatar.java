package com.hellokoding.auth.model;


import com.hellokoding.auth.util.BaseModel;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "ospatari")
public class Ospatar extends BaseModel implements Comparable{

    private Long id;
    private String nume;
    private String email;
    private String parola;
    private String passwordConfirm;
    private String status;
    private List<Review> reviews;
    private List<Comanda> listaComenzi;
    private int sters;
    private Restaurant restaurant;
    @ManyToOne
    @JoinColumn(name="restaurant_id", nullable=false)
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
    @OneToMany(cascade=ALL, mappedBy="review")
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @OneToMany(cascade=ALL, mappedBy="comanda")
    public List<Comanda> getListaComenzi() {
        return listaComenzi;
    }

    public void setListaComenzi(List<Comanda> listaComenzi) {
        this.listaComenzi = listaComenzi;
    }


    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(Object o) {
        Ospatar ospatar=(Ospatar) o;
        return this.getNume().compareTo(ospatar.getNume());
    }

    public int getSters() {
        return sters;
    }

    public void setSters(int sters) {
        this.sters = sters;
    }
}
