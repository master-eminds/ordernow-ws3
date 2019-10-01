package com.hellokoding.auth.web;

import com.hellokoding.auth.model.Ospatar;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.model.list.OspatarList;
import com.hellokoding.auth.service.OspatarService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.util.BaseModel;
import com.hellokoding.auth.util.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    private UserService userService;


    //-----ADD OSPATAR-----
    @RequestMapping(value = "/registerUser/{token}", method = RequestMethod.POST)
    @ResponseBody
    public User registerUser(@RequestBody User user, @PathVariable String token) {
        //gmail/facebook
        if(token!=null&& token!="0"){
            //gmail
            user.setAccountType(1);
        }
        //incognito
        else{
            String newToken=Global.createToken();
            user.setToken(newToken);
            user.setAccountType(0);
        }
        try{
            user=userService.save(user);
            user.setResult("OK");
        } catch (Exception e) {
            e.printStackTrace();
            user.setResult("ERR");
        }
        return user;
    }
/*
    //----- EDIT USER   -----
    @RequestMapping(value = "/editUser/{newToken}", method = RequestMethod.PUT)
    @ResponseBody
    public User editUser(@RequestBody User user, @PathVariable String newToken) {
        User userInfo= new User();
        try{
            userService.updateUserAccount(user,newToken);
            userInfo.setResult("OK");
        } catch (Exception e) {
            e.printStackTrace();
            userInfo.setResult("ERR");
        }
        return userInfo;
    }*/

/*    //------DELETE OSPATAR
    @RequestMapping(value = "/deleteOspatar/{id}", method = RequestMethod.PUT)
    public BaseModel deleteOspatar(@PathVariable("id") Long id) {
        BaseModel resp = new BaseModel();
        try {
            ospatarService.delete(id);
            resp.setResult("OK");
        } catch (Exception e) {
            e.printStackTrace();
            resp.setResult("ERR");
        }
        return resp;
    }
    //-------GET LISTA OSPATARI--------
    @RequestMapping(value = "/getListaOspatariByIdRestaurant/{idRestaurant}", method = RequestMethod.GET)
    @ResponseBody
    public OspatarList getListaOspatariByIdRestaurant(@PathVariable Long idRestaurant) {
        List<Ospatar> ospatari=new ArrayList<>();
        OspatarList ospatarList = new OspatarList();

        try{
            ospatari = ospatarService.findAllByIdRestaurant(idRestaurant);
            ospatarList.setResult("OK");
        }
        catch (Exception e){
            ospatarList.setResult("ERR");
        }

        ospatarList.setOspatarList(ospatari);
        return ospatarList;
    }*/
}
