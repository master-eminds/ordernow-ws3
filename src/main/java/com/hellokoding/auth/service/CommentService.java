package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Comment;
import com.hellokoding.auth.model.Image;

import java.util.List;

public interface CommentService {

    Comment save(Comment comment);

    Comment findById(Long id);
    void delete(Long id);
    List<Comment> findAll();
    List<Comment> findAllByIdRestaurant(Long idRestaurant);
    int findNrByIdRestaurant(Long idRestaurant);

}
