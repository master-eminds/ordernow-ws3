package com.hellokoding.auth.model;

import javax.persistence.*;

@Entity
@Table(name="review")
public class Review {

    private Long id;
  /*  private Long restaurantId;
    private Long userId;
    private Long waiterId;
    private Long productId;*/
    private String comment;
    private Long like_vote;

    private User user;
    private Restaurant restaurant;
    private Ospatar waiter;
    private Product product;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getLike_vote() {
        return like_vote;
    }

    public void setLike_vote(Long like_vote) {
        this.like_vote = like_vote;
    }

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @ManyToOne
    @JoinColumn(name="restaurant_id", nullable=false)
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    @ManyToOne
    @JoinColumn(name="waiter_id", nullable=false)
    public Ospatar getWaiter() {
        return waiter;
    }

    public void setWaiter(Ospatar waiter) {
        this.waiter = waiter;
    }
    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
