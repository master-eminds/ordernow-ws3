package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Image;
import com.hellokoding.auth.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepository imageRepository;
    @PersistenceContext
    private EntityManager em;

    @Override
    public Image save(Image image) {
        return imageRepository.saveAndFlush(image);
    }

    @Override
    public Image findById(Long id) {
        return imageRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        imageRepository.delete(id);
    }

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public List<Image> findAllByIdRestaurant(Long idRestaurant) {
        List imagini = em.createNativeQuery(
                "select * from imagini where restaurant_id=:1 ", Image.class)
                .setParameter(1, idRestaurant)
                .getResultList();
        return imagini;
    }

}
