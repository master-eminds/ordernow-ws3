package com.hellokoding.auth.web;

import com.hellokoding.auth.model.Produs;
import com.hellokoding.auth.service.ProdusService;
import com.hellokoding.auth.util.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ProdusController {
    @Autowired
    private ProdusService produsService;

    @RequestMapping(value = "/addProdus", method = RequestMethod.POST)
    public Produs addProdus(@RequestBody Produs produs) {
        Produs infoProdus = new Produs();
        try {
            infoProdus = produsService.save(produs);
            infoProdus.setResult("OK");
        } catch (Exception e) {
            e.printStackTrace();
            infoProdus.setResult("ERR");
        }
        return infoProdus;
    }

    @RequestMapping(value = "/deleteProdus/{id}", method = RequestMethod.PUT)
    public BaseModel deleteProdus(@PathVariable("id") Long id) {
        BaseModel resp = new BaseModel();
        try {
            produsService.delete(id);
            resp.setResult("OK");
        } catch (Exception e) {
            e.printStackTrace();
            resp.setResult("ERR");
        }
        return resp;
    }

    @RequestMapping(value = "/editProdus", method = RequestMethod.PUT)
    public Produs editProdus(@RequestBody Produs produs) {
        Produs resp = new Produs();
        try {
            resp = produsService.saveOrUpdate(produs);
            resp.setResult("OK");
        } catch (Exception e) {
            e.printStackTrace();
            resp.setResult("ERR");
        }
        return resp;
    }

}
