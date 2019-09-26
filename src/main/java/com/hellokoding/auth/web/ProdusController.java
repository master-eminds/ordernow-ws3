package com.hellokoding.auth.web;

import com.hellokoding.auth.model.InfoOffer;
import com.hellokoding.auth.model.InfoProduct;
import com.hellokoding.auth.model.Product;
import com.hellokoding.auth.model.list.InfoOfferList;
import com.hellokoding.auth.model.list.InfoProductList;
import com.hellokoding.auth.service.ProdusService;
import com.hellokoding.auth.util.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ProdusController {
    @Autowired
    private ProdusService produsService;

    @RequestMapping(value = "/addProdus", method = RequestMethod.POST)
    public Product addProdus(@RequestBody Product product) {
        Product infoProduct = new Product();
        try {
            infoProduct = produsService.save(product);
            infoProduct.setResult("OK");
        } catch (Exception e) {
            e.printStackTrace();
            infoProduct.setResult("ERR");
        }
        return infoProduct;
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
    public Product editProdus(@RequestBody Product product) {
        Product resp = new Product();
        try {
            resp = produsService.saveOrUpdate(product);
            resp.setResult("OK");
        } catch (Exception e) {
            e.printStackTrace();
            resp.setResult("ERR");
        }
        return resp;
    }

    //-------GET LISTA PRODUSE BY CATEGORIE--------
    @RequestMapping(value = "/getProductsByIdCateg/{idCategory}", method = RequestMethod.GET)
    @ResponseBody
    public InfoProductList getProductsByIdCateg(@PathVariable Long idCategory) {
        InfoProductList infoProductList = new InfoProductList();
        List<InfoProduct> products;
        try {
            products = produsService.findAllByCategorie(idCategory);
            infoProductList.setInfoProductList(products);
            infoProductList.setResult("OK");
        } catch (Exception e) {
            infoProductList.setResult("ERR");
        }

        return infoProductList;
    }

    //-------GET PRODUS BY ID--------
    @RequestMapping(value = "/getProductById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Product getProductById(@PathVariable Long id) {
        Product product = null;
        try {
            product = produsService.findById(id);
            product.setResult("OK");
        } catch (Exception e) {
            product.setResult("ERR");
        }

        return product;
    }
}
