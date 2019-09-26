package com.hellokoding.auth.model;

import javax.persistence.*;

@Entity
@Table(name="review")
public class Review {

    private Long id;
    private String comentariu;
    private float nota;
    private Product product;
    private Ospatar ospatar;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentariu() {
        return comentariu;
    }

    public void setComentariu(String comentariu) {
        this.comentariu = comentariu;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @ManyToOne
    @JoinColumn(name="id_produs", nullable=false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    @ManyToOne
    @JoinColumn(name="id_ospatar", nullable=false)
    public Ospatar getOspatar() {
        return ospatar;
    }

    public void setOspatar(Ospatar ospatar) {
        this.ospatar = ospatar;
    }
}
