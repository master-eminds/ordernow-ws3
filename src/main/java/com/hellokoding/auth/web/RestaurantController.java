package com.hellokoding.auth.web;

import com.hellokoding.auth.model.Admin;
import com.hellokoding.auth.model.InfoRestaurant;
import com.hellokoding.auth.model.Restaurant;
import com.hellokoding.auth.model.list.InfoRestaurantList;
import com.hellokoding.auth.service.RestaurantService;
import com.hellokoding.auth.util.BaseModel;
import com.hellokoding.auth.util.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    //--------ADD/EDIT RESTAURANT----------
    @RequestMapping(value = "/salvareRestaurant", method = RequestMethod.POST)
    public Restaurant salveazaRestaurant(@RequestBody Restaurant restaurant) {

        if (restaurant.getId() != null && restaurant.getId() != 0) {
            try {
                restaurant = restaurantService.update(restaurant);
                restaurant.setResult("OK");
            } catch (Exception e) {
                e.printStackTrace();
                restaurant.setResult("ERR");
            }
        } else {
            try {
                restaurant = restaurantService.save(restaurant);
                restaurant.setResult("OK");

            } catch (Exception e) {
                e.printStackTrace();
                restaurant.setResult("ERR");

            }
        }

        return restaurant;
    }

    //-------GET LISTA RESTAURANTE--------
    @RequestMapping(value = "/vizualizareRestaurante", method = RequestMethod.GET)
    @ResponseBody
    public InfoRestaurantList getRestaurante() {
        List<Restaurant> restaurante=new ArrayList<>();
        InfoRestaurantList infoRestaurantList = new InfoRestaurantList();
        List<InfoRestaurant> infoRestaurante = new ArrayList<>();
        //find personalizat
        try{
            restaurante = restaurantService.findAll();
            infoRestaurantList.setResult("OK");
        }
        catch (Exception e){
            infoRestaurantList.setResult("ERR");
        }

        for (Restaurant r : restaurante) {
            if(r.getActiv()==1) {
                InfoRestaurant restaurant = new InfoRestaurant();
                restaurant.setId(r.getId());
                restaurant.setDenumire(r.getDenumire());
                restaurant.setDescriere(r.getDescriere());
                restaurant.setImagine(r.getImagine());
                restaurant.setBarCode(r.getBarCode());
                restaurant.setComandaOnline(r.getComandaOnline());
                infoRestaurante.add(restaurant);
            }
        }
        infoRestaurantList.setInfoRestaurantList(infoRestaurante);
        return infoRestaurantList;
    }

    //-------GET RESTAURANT BY ID--------
    @RequestMapping(value = "/getRestaurantById/{idRestaurant}", method = RequestMethod.GET)
    @ResponseBody
    public Restaurant getRestaurantById(@PathVariable Long idRestaurant) {

        Restaurant restaurant=new Restaurant();
        try {
            restaurant = restaurantService.findById(idRestaurant);
            restaurant.setResult("OK");
        }
        catch(Exception e){
            restaurant.setResult("ERR");
        }
        return restaurant;
    }
    //-------delete RESTAURANT BY ID--------
    @RequestMapping(value = "/deleteRestaurantById/{idRestaurant}", method = RequestMethod.GET)
    @ResponseBody
    public BaseModel deleteRestaurantById(@PathVariable Long idRestaurant) {

        BaseModel restaurantInfo=new BaseModel();
        try{
            restaurantService.delete(idRestaurant);
            restaurantInfo.setResult("OK");

        }
        catch(Exception e){
            restaurantInfo.setResult("ERR");
        }

        return restaurantInfo;
    }
}
