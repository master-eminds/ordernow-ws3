package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Comment;
import com.hellokoding.auth.model.Image;
import com.hellokoding.auth.repository.CommentRepository;
import com.hellokoding.auth.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;
    @PersistenceContext
    private EntityManager em;

    @Override
    public Comment save(Comment comment) {
        return commentRepository.saveAndFlush(comment);
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        commentRepository.delete(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> findAllByIdRestaurant(Long idRestaurant) {
        List comentarii = em.createNativeQuery(
                "select * from comentarii where restaurant_id=:1 ", Comment.class)
                .setParameter(1, idRestaurant)
                .getResultList();
        return comentarii;
    }
    @Override
    public int findNrByIdRestaurant(Long idRestaurant) {
        int nr = em.createNativeQuery(
                "select count(*) from comentarii where restaurant_id=:1 ")
                .setParameter(1, idRestaurant)
                .getFirstResult();
        return nr;
    }
}
