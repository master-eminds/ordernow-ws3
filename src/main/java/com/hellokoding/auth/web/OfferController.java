package com.hellokoding.auth.web;

import com.hellokoding.auth.model.Category;
import com.hellokoding.auth.model.InfoCategory;
import com.hellokoding.auth.model.InfoOffer;
import com.hellokoding.auth.model.list.InfoCategoryList;
import com.hellokoding.auth.model.list.InfoOfferList;
import com.hellokoding.auth.repository.CategorieRepository;
import com.hellokoding.auth.service.CategorieService;
import com.hellokoding.auth.service.MeniuService;
import com.hellokoding.auth.service.OfferService;
import com.hellokoding.auth.service.ProdusService;
import com.hellokoding.auth.util.Global;
import com.hellokoding.auth.validator.CategorieValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OfferController {
    @Autowired
    private ProdusService produsService;

    @Autowired
    private OfferService offerService;
@Autowired
private CategorieRepository categorieRepository;
    @Autowired
    private MeniuService meniuService;
@Autowired
private CategorieValidator categorieValidator;


    //-------GET LISTA CATEGORII--------
    @RequestMapping(value = "/getOffersByIdMenu/{idMenu}", method = RequestMethod.GET)
    @ResponseBody
    public InfoOfferList getOffersByIdMenu(@PathVariable Long idMenu) {
        InfoOfferList infoOfferList= new InfoOfferList();
        List<InfoOffer> offers;
        try{
            offers = offerService.findAllInfoByMeniuId(idMenu);
            infoOfferList.setInfoOfferList(offers);
            infoOfferList.setResult("OK");
        }
        catch (Exception e){
            infoOfferList.setResult("ERR");
        }

        return infoOfferList;
    }
}
