package com.hellokoding.auth.web;

import com.hellokoding.auth.model.Admin;
import com.hellokoding.auth.model.InfoAdmin;
import com.hellokoding.auth.service.AdminService;
import com.hellokoding.auth.util.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    //-----ADD ADMIN-----
    @RequestMapping(value = "/registerAdmin", method = RequestMethod.PUT)
    @ResponseBody
    public Admin registerAdmin(@RequestBody Admin admin) {

       try{
           admin=adminService.save(admin);
           admin.setResult("OK");
       } catch (Exception e) {
           e.printStackTrace();
           admin.setResult("ERR");
       }
        return admin;
    }

    //----- EDIT ADMIN-----
    @RequestMapping(value = "/editAdmin", method = RequestMethod.PUT)
    @ResponseBody
    public Admin editAdmin(@RequestBody Admin admin) {
        Admin adminInfo= new Admin();
        try{
            adminService.update(admin);
            adminInfo.setResult("OK");
        } catch (Exception e) {
            e.printStackTrace();
            adminInfo.setResult("ERR");
        }
        return adminInfo;
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Admin login(@RequestBody InfoAdmin infoAdmin) {

        Admin resp= new Admin();
       Admin admin= adminService.findByUsername(infoAdmin.getUsername());
       String pass= infoAdmin.getPassword();
        try {
            if(Global.criptare(pass, Global.cheieCriptare).equals(admin.getPassword())){
             resp.setResult("OK");
            }
            else{
                resp.setResult("ERR");
                resp.setExtendedInfo("Username or password invalid!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.setResult("ERR");
        }
        return resp;
    }




}
