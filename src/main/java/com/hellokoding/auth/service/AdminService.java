package com.hellokoding.auth.service;

import com.hellokoding.auth.model.Admin;
import com.hellokoding.auth.model.Ospatar;

public interface AdminService {
    Admin save(Admin admin) throws Exception;
    void update(Admin admin);
    void delete(Long id);
    Admin findByUsername(String username);

    Admin findById(Long id);

}
