package com.hellokoding.auth.model;

import com.hellokoding.auth.util.BaseModel;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="mese")
public class Masa extends BaseModel {
    private Long id;
    private List<Comanda> comenzi;
    private Integer sters;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @OneToMany(fetch = FetchType.EAGER,cascade=ALL, mappedBy="masa")
    public List<Comanda> getComenzi() {
        return comenzi;
    }

    public void setComenzi(List<Comanda> comenzi) {
        this.comenzi = comenzi;
    }

    public Integer getSters() {
        return sters;
    }

    public void setSters(Integer sters) {
        this.sters = sters;
    }
}
