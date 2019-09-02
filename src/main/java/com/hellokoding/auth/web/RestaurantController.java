package com.hellokoding.auth.web;

import com.hellokoding.auth.model.Admin;
import com.hellokoding.auth.model.Restaurant;
import com.hellokoding.auth.service.RestaurantService;
import com.hellokoding.auth.util.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @RequestMapping(value = "/adaugareRestaurant/{id}", method = RequestMethod.GET)
    public ModelAndView administrareAdmin(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView("adaugareRestaurant");
        if(id == 0 ){
            model.addObject("restaurantForm", new Restaurant());
            model.addObject("add","true");
        }else{
            Restaurant o = restaurantService.findById(id);
            model.addObject("restaurantForm",o);
            model.addObject("add","false");
        }
        return model;
    }
    @RequestMapping(value = "/salvareRestaurant", method = RequestMethod.POST)
    public String adaugareAdmin(@ModelAttribute("restaurantForm") Restaurant restaurantForm, BindingResult bindingResult, Model model) {

        if(restaurantForm.getId()!=null&& restaurantForm.getId()!=0){
            if(bindingResult.hasErrors()){
                return "adaugareRestaurant";
            }
            try {
            restaurantService.update(restaurantForm);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            if(bindingResult.hasErrors()){
                return "adaugareRestaurant";
            }
            try {
              restaurantService.saveVoid(restaurantForm);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "redirect:/login";

    }
    @RequestMapping(value = "/vizualizareRestaurante", method = RequestMethod.GET)
    public ModelAndView vizualizareRest()  {
        ModelAndView model = new ModelAndView("vizualizareRestaurante");

        List<Restaurant> restaurante;
        restaurante=restaurantService.findAll();
        model.addObject("restaurante",restaurante);

        return model;
    }

   /* @RequestMapping(value = "/adaugareRestaurant/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Restaurant administrareRestaurantWS(@PathVariable("id") Long id) {
        Restaurant restaurant = null;
        if(id == 0 ){
            restaurant = new Restaurant();
        }else{
            Restaurant o = restaurantService.findById(id);
            restaurant = o;
        }
        return restaurant;
    }
    */
/*

    @RequestMapping(value = "/salvareRestaurant", method = RequestMethod.POST)
    public Restaurant salveazaRestaurant(@ModelAttribute("restaurantForm") Restaurant restaurantForm, BindingResult bindingResult, Model model) {

        Restaurant restaurant=null;
        if(restaurantForm.getId()!=null&& restaurantForm.getId()!=0){
            try {
               restaurant= restaurantService.update(restaurantForm);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            try {
              restaurant=  restaurantService.save(restaurantForm);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return restaurant;
    }

*/


   /* @RequestMapping(value = "/vizualizareRestaurante", method = RequestMethod.GET)
    @ResponseBody
    public List<Restaurant> getRestaurante()  {
        List<Restaurant> restaurante;
        restaurante=restaurantService.findAll();

        return restaurante;
    }*/


}
