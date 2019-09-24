package com.hellokoding.auth.web;

import com.hellokoding.auth.model.*;
import com.hellokoding.auth.model.list.*;
import com.hellokoding.auth.service.*;
import com.hellokoding.auth.util.*;
import com.hellokoding.auth.validator.AdminValidator;
import com.hellokoding.auth.validator.ModificareAdminValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private MesajService mesajService;

    @Autowired
    private RolService rolService;
    @Autowired
    private MasaService masaService;
    @Autowired
    private OspatarService ospatarService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private ComandaService comandaService;
    @Autowired
    private SugestieService sugestieService;
    @Autowired
    private ProdusService produsService;
    @Autowired
    private MeniuService meniuService;
    @Autowired
    private ReviewService reviewService;

    private DateNecesare dateNecesare = new DateNecesare();

    @Autowired
    private AdminValidator adminValidator;
    @Autowired
    private ModificareAdminValidator modificareAdminValidator;

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
