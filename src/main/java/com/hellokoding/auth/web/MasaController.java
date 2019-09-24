package com.hellokoding.auth.web;

import com.hellokoding.auth.model.Masa;
import com.hellokoding.auth.model.list.MeseList;
import com.hellokoding.auth.repository.MasaRepository;
import com.hellokoding.auth.service.MasaService;
import com.hellokoding.auth.util.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MasaController {
    @Autowired
    private MasaService masaService;

    @Autowired
    private MasaRepository masaRepository;

    //------ADD MASA--------
    @RequestMapping(value = "/addMasa", method = RequestMethod.POST)
    public Masa addMasa(@RequestBody Masa masa) {
        Masa infoMasa= new Masa();
        try{
            infoMasa= masaService.save(masa);
            infoMasa.setResult("OK");
        }catch (Exception e){
            e.printStackTrace();
            infoMasa.setResult("ERR");
        }

        return infoMasa;
    }

    //------DELETE MASA
    @RequestMapping(value = "/deleteMasa/{id}", method = RequestMethod.PUT)
    public BaseModel deleteMasa(@PathVariable("id") Long id) {
        BaseModel info= new BaseModel();
        try{
            masaRepository.deleteMasa(id);
            info.setResult("OK");
        }catch(Exception e){
            e.printStackTrace();
            info.setResult("ERR");
        }
        return info;
    }
    //-------GET LISTA MESE--------
    @RequestMapping(value = "/getListaMeseByIdRestaurant/{idRestaurant}", method = RequestMethod.GET)
    @ResponseBody
    public MeseList getListaMeseByIdRestaurant(@PathVariable Long idRestaurant) {
        List<Masa> mese=new ArrayList<>();
        MeseList meseList = new MeseList();

        try{
            mese = masaService.findAllByIdRestaurant(idRestaurant);
            meseList.setResult("OK");
        }
        catch (Exception e){
            meseList.setResult("ERR");
        }

        meseList.setMeseList(mese);
        return meseList;
    }
}
