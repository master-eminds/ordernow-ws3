package com.hellokoding.auth.web;

import com.hellokoding.auth.model.Comanda;
import com.hellokoding.auth.model.ItemComanda;
import com.hellokoding.auth.model.list.ComandaList;
import com.hellokoding.auth.model.list.ItemComandaList;
import com.hellokoding.auth.service.ComandaService;
import com.hellokoding.auth.util.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ComandaController {
    @Autowired
    private ComandaService comandaService;


    //-------GET LISTA COMENZI--------
    @RequestMapping(value = "/getListaComenziByIdRestaurant/{idRestaurant}", method = RequestMethod.GET)
    @ResponseBody
    public ComandaList getListaComenziByIdRestaurant(@PathVariable Long idRestaurant) {
        List<Comanda> comenzi=new ArrayList<>();
        ComandaList comandaList = new ComandaList();

        try{
            comenzi = comandaService.findAllByIdRestaurant(idRestaurant);
            comandaList.setResult("OK");
        }
        catch (Exception e){
            comandaList.setResult("ERR");
        }

        comandaList.setComandaList(comenzi);
        return comandaList;
    }
    //---- GET ITEMI COMENZI
    @RequestMapping(value = "/getItemsByIdComanda/{idComanda}", method = RequestMethod.GET)
    public ItemComandaList getItemsByIdComanda(@PathVariable Long idComanda) throws ParseException {

        Comanda comanda = comandaService.findById(idComanda);
        ItemComandaList itemComandaList = new ItemComandaList();
        List<ItemComanda> itemiComanda = comanda.getListaItemComanda();
        itemComandaList.setItemComandaList(itemiComanda);
        return itemComandaList;
    }

    //--------ADD COMANDA ---------
    @RequestMapping(value = "/addComanda", method = RequestMethod.POST)
    public Comanda addComanda(@RequestBody Comanda comanda) {

        Comanda resp = new Comanda();
        try {
            resp = comandaService.save(comanda);
            resp.setResult("OK");
        } catch (Exception e) {
            e.printStackTrace();
            resp.setResult("ERR");
        }
        return resp;
    }
    //--------EDIT COMANDA ---------
    @RequestMapping(value = "/editComanda", method = RequestMethod.POST)
    public Comanda editComanda(@RequestBody Comanda comanda) {

        Comanda resp = new Comanda();
        try {
            resp= comandaService.update(comanda);
            resp.setResult("OK");
        } catch (Exception e) {
            e.printStackTrace();
            resp.setResult("ERR");
        }
        return resp;
    }

    //--------DELETE COMANDA ---------
    @RequestMapping(value = "/deleteComanda/{idComanda}", method = RequestMethod.PUT)
    public BaseModel deleteComanda(@PathVariable Long idComanda) {

        BaseModel resp = new BaseModel();
        try {
            comandaService.delete(idComanda);
            resp.setResult("OK");
        } catch (Exception e) {
            e.printStackTrace();
            resp.setResult("ERR");
        }
        return resp;
    }
}
