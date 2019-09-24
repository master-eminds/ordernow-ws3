package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Admin;
import com.hellokoding.auth.repository.AdminRepository;
import com.hellokoding.auth.repository.RoleRepository;
import com.hellokoding.auth.util.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public Admin save(Admin admin) {
        String password= admin.getPassword();
        admin.setPassword(bCryptPasswordEncoder.encode(password));
        return adminRepository.saveAndFlush(admin);
    }

    @Override
    public void update(Admin admin) {

        if(admin.getId()!=null){
                adminRepository.delete(admin.getId());
            }
        String password= admin.getPassword();
        admin.setPassword(bCryptPasswordEncoder.encode(password));
        adminRepository.save(admin);
    }

    @Override
    public void delete(Long id) {
        adminRepository.delete(id);
    }

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public Admin findById(Long id) {
        return adminRepository.findOne(id);
    }


}
