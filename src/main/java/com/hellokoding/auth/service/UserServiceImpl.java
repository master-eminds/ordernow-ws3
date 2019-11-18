package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Ospatar;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.repository.OspatarRepository;
import com.hellokoding.auth.repository.UserRepository;
import com.hellokoding.auth.util.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @PersistenceContext
    EntityManager em;

    @Override
    public User save(User user) {

        try {
            user.setPassword(Global.criptare(user.getPassword(),Global.cheieCriptare));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userRepository.saveAndFlush(user);
    }


    @Override
    public User findById(Long id) {

        return userRepository.findOne(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void update(User user) {
        if(user.getId()!=null){
            userRepository.delete(user.getId());
        }
        String password= user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userRepository.save(user);
    }

    @Override
    public void updateUserAccount(User user, String newToken) {

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }




}
