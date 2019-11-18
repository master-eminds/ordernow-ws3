package com.hellokoding.auth.web;

import com.hellokoding.auth.model.Menu;
import com.hellokoding.auth.model.list.MeniuList;
import com.hellokoding.auth.repository.MeniuRepository;
import com.hellokoding.auth.service.CategorieService;
import com.hellokoding.auth.service.MeniuService;
import com.hellokoding.auth.service.OfferService;
import com.hellokoding.auth.util.Global;
import com.hellokoding.auth.validator.MeniuValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MeniuController {
    @Autowired
    private MeniuService meniuService;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private OfferService offerService;
    @Autowired
    private MeniuRepository meniuRepository;

    @Autowired
    private MeniuValidator meniuValidator;

    @RequestMapping(value = "/mitza", method = RequestMethod.GET)
    @ResponseBody
    public String mitza() {
        String obj = "hello";
        return obj;
    }

    @RequestMapping(value = "/vizualizareMeniuri", method = RequestMethod.GET)
    public ModelAndView vizualizareMeniuri() {
        ModelAndView model = new ModelAndView("vizualizareMeniuri");
        if(Global.listaMeniuri==null||Global.listaMeniuri.size()==0) {
           Global.listaMeniuri = meniuService.findAll();
        }
        model.addObject("meniuri", Global.listaMeniuri);

        return model;
    }
    @RequestMapping(value = "/vizualizareMeniuri/{stare}", method = RequestMethod.GET)
    public ModelAndView vizualizareMeniuriByStare(@PathVariable("stare") String stare) {
        ModelAndView model = new ModelAndView("vizualizareMeniuri");
        if(Global.listaMeniuri==null||Global.listaMeniuri.size()==0) {
           Global.listaMeniuri = meniuService.findAll();
        }
        List<Menu> listaByStare=new ArrayList<>();
        for(Menu m: Global.listaMeniuri){

        }/*  if(m.getStare().equals(stare)){
                listaByStare.add(m);
            }*/
        model.addObject("meniuri", listaByStare);

        return model;
    }
    @RequestMapping(value = "/administrareMeniu/{id}", method = RequestMethod.GET)
    public ModelAndView registration(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView("administrareMeniu");

        if(id == 0 ){
            Menu m= new Menu();
            /*if(m.getStare()==null){
                m.setStare("0");
            }*/
            model.addObject("meniuForm", m);
            model.addObject("add","true");
        }else{
            Menu m = meniuService.findById(id);
            model.addObject("meniuForm",m);
            model.addObject("add","false");
            model.addObject("imageSrc",new String(m.getImage().getByteImage()));

        }
        return model;
    }


    @RequestMapping(value = "/salvareMeniu", method = RequestMethod.POST)
    public String adaugareMeniu(@ModelAttribute("meniuForm") Menu menuForm, BindingResult bindingResult)  {

        meniuValidator.validate(menuForm,bindingResult);
        if(bindingResult.hasErrors()){
            return "administrareMeniu";
        }
        if(menuForm.getId()!=null){
            int sters=0;
            for(int i=0;i<Global.listaMeniuri.size() && sters==0;i++){
                Menu menu =Global.listaMeniuri.get(i);
                if(menu.getId().equals(menuForm.getId())){
                    Global.listaMeniuri.remove(i);
                    sters=1;
                }
            }
        }

        Menu menu =meniuService.save(menuForm);
        Global.listaMeniuri.add(menu);
        return "redirect:/vizualizareMeniuri";
    }


    @RequestMapping(value = "/stergeMeniu/{meniu_id}", method = RequestMethod.GET)
    public String stergeMeniu(@PathVariable("meniu_id") Long meniu_id) {

        int sters=0;
        for(int i=0;i<Global.listaMeniuri.size() && sters==0;i++){
            Menu menu =Global.listaMeniuri.get(i);
            if(menu.getId().equals(meniu_id)){
                Global.listaMeniuri.remove(i);
                sters=1;
            }
        }
        meniuRepository.deleteMeniu(meniu_id);


        return "redirect:/vizualizareMeniuri";
    }

    //-------GET LISTA MENIURI--------
    @RequestMapping(value = "/getMenuByIdRestaurant/{idRestaurant}", method = RequestMethod.GET)
    @ResponseBody
    public Menu getMenuByIdRestaurant(@PathVariable Long idRestaurant) {
        Menu menu = new Menu();

        try{
            menu = meniuService.findByIdRestaurant(idRestaurant);
            menu.setResult("OK");
        }
        catch (Exception e){
            menu.setResult("ERR");
        }

        return menu;
    }

}
