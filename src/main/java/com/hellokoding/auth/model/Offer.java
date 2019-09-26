package com.hellokoding.auth.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="oferte")
public class Offer {

    private Long id;
    private String name;
    private String description;
    private List<Product> products;
    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(length=100000)
    private byte[] image;
    private int active;
    private Double price;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Double getPrice() {

        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
