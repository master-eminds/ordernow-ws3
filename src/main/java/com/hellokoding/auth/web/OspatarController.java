package com.hellokoding.auth.web;

import com.hellokoding.auth.model.Ospatar;
import com.hellokoding.auth.model.list.OspatarList;
import com.hellokoding.auth.service.OspatarService;
import com.hellokoding.auth.util.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OspatarController {


    @Autowired
    private OspatarService ospatarService;


    //-----ADD OSPATAR-----
    @RequestMapping(value = "/registerOspatar", method = RequestMethod.PUT)
    @ResponseBody
    public Ospatar registerOspatar(@RequestBody Ospatar ospatar) {

        try{
            ospatar=ospatarService.save(ospatar);
            ospatar.setResult("OK");
        } catch (Exception e) {
            e.printStackTrace();
            ospatar.setResult("ERR");
        }
        return ospatar;
    }

    //----- EDIT OSPATAR-----
    @RequestMapping(value = "/editOspatar", method = RequestMethod.PUT)
    @ResponseBody
    public Ospatar editOspatar(@RequestBody Ospatar ospatar) {
        Ospatar ospatarInfo= new Ospatar();
        try{
            ospatarService.update(ospatar);
            ospatarInfo.setResult("OK");
        } catch (Exception e) {
            e.printStackTrace();
            ospatarInfo.setResult("ERR");
        }
        return ospatarInfo;
    }
    //------DELETE OSPATAR
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
    }
}
