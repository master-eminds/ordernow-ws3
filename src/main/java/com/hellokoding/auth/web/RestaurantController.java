package com.hellokoding.auth.web;

import com.hellokoding.auth.model.InfoRestaurant;
import com.hellokoding.auth.model.Restaurant;
import com.hellokoding.auth.model.list.InfoRestaurantList;
import com.hellokoding.auth.service.CommentService;
import com.hellokoding.auth.service.ImageService;
import com.hellokoding.auth.service.RestaurantService;
import com.hellokoding.auth.util.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CommentService commentService;
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
    @RequestMapping(value = "/getRestaurants", method = RequestMethod.GET)
    @ResponseBody
    public InfoRestaurantList getRestaurants() {
        InfoRestaurantList infoRestaurantList = new InfoRestaurantList();
        List<InfoRestaurant> infoRestaurante = new ArrayList<>();
        try{
            infoRestaurante = restaurantService.getInfoAllRestaurants();
            for(InfoRestaurant restaurant: infoRestaurante){
                restaurant.setImages(imageService.findAllByIdRestaurant(restaurant.getId()));
                restaurant.setNrComments(commentService.findNrByIdRestaurant(restaurant.getId()));
            }

            infoRestaurantList.setResult("OK");
        }
        catch (Exception e){
            infoRestaurantList.setResult("ERR");
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
    @RequestMapping(value = "/deleteRestaurantById/{idRestaurant}", method = RequestMethod.PUT)
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
