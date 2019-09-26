package com.hellokoding.auth.web;

import com.hellokoding.auth.model.Category;
import com.hellokoding.auth.model.InfoCategory;
import com.hellokoding.auth.model.Menu;
import com.hellokoding.auth.model.list.CategorieList;
import com.hellokoding.auth.model.list.InfoCategoryList;
import com.hellokoding.auth.repository.CategorieRepository;
import com.hellokoding.auth.service.CategorieService;
import com.hellokoding.auth.service.MeniuService;
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
public class CategorieController {
    @Autowired
    private ProdusService produsService;

    @Autowired
    private CategorieService categorieService;
@Autowired
private CategorieRepository categorieRepository;
    @Autowired
    private MeniuService meniuService;
@Autowired
private CategorieValidator categorieValidator;

    @RequestMapping(value = "/vizualizareCategorii/{meniu_id}/{vizibilitate}", method = RequestMethod.GET)
            public ModelAndView vizualizareCategorii(@PathVariable ("meniu_id") Long meniu_id, @PathVariable("vizibilitate") String vizibilitate) {
            ModelAndView model = new ModelAndView("vizualizareCategorii");

          List<Category> listaCategorii=new ArrayList<>();
          for(Category category : Global.mapCategoriiByMeniu.get(meniu_id)){
              /*if (category.getVizibilitate().equals(vizibilitate)){
                  listaCategorii.add(category);
              }*/
          }
                  //categorieService.findAllByVizibilitate(meniu_id,vizibilitate);

        model.addObject("categorii", listaCategorii);
        model.addObject("meniu_id",meniu_id);
        return model;
}
    @RequestMapping(value = "/vizualizareCategorii/{meniu_id}", method = RequestMethod.GET)
    public ModelAndView vizualizareCategorii(@PathVariable("meniu_id") Long meniu_id) {
        ModelAndView model = new ModelAndView("vizualizareCategorii");
        if(Global.mapCategoriiByMeniu.get(meniu_id)==null||Global.mapCategoriiByMeniu.get(meniu_id).size()==0) {
          // Global.mapCategoriiByMeniu.put(meniu_id, categorieService.findAllByMeniuId(meniu_id));
        }
        model.addObject("categorii", Global.mapCategoriiByMeniu.get(meniu_id));
        model.addObject("meniu_id",meniu_id);

        return model;
    }
    @RequestMapping(value = "/administrareCategorie/{categorie_id}/{meniu_id}", method = RequestMethod.GET)
    public ModelAndView registration(@PathVariable("categorie_id") Long categorie_id,@PathVariable("meniu_id") Long meniu_id) {
        ModelAndView model = new ModelAndView("administrareCategorie");
        if(categorie_id == 0 ){
            /*Menu menu = meniuService.findById(meniu_id);
            Category c= new Category(menu);
            if(c.getVizibilitate()==null){
                c.setVizibilitate("0");
            }*/
           // model.addObject("categorieForm", c);
            model.addObject("add","true");
        }else{
            Category c = categorieService.findById(categorie_id);
            model.addObject("categorieForm",c);
            model.addObject("add","false");
           // model.addObject("imageSrc",new String(c.getImagine()));
        }
        return model;
    }


    @RequestMapping(value = "/salvareCategorie/{meniu_id}", method = RequestMethod.POST)
    public String adaugareMeniu(@ModelAttribute("categorieForm") Category categoryForm, @PathVariable("meniu_id") Long meniu_id, BindingResult bindingResult) throws UnsupportedEncodingException, SQLException {

        categorieValidator.validate(categoryForm,bindingResult);
        if(bindingResult.hasErrors()){
            return "administrareCategorie";
        }
        //categoryForm.setMenu(meniuService.findById(meniu_id));
        if(bindingResult.hasErrors()){
            return "administrareCategorie";
        }
        Category category =categorieService.save(categoryForm);
        //modificare category
        if(categoryForm.getId()!=0){
            if (Global.mapCategoriiByMeniu.get(meniu_id)!=null&&Global.mapCategoriiByMeniu.get(meniu_id).size()!=0){
                List<Category> listaVeche=  stergeCategorie(meniu_id, category);
                listaVeche.add(category);
                Global.mapCategoriiByMeniu.replace(meniu_id,listaVeche);
            }
        }
        //adaugare category
        else {
            //daca exista deja macar o category in meniu, actualizam lista veche adaugand categoria noua
            if (Global.mapCategoriiByMeniu.get(meniu_id)!=null&&Global.mapCategoriiByMeniu.get(meniu_id).size()!=0){
                List<Category> listaVeche= Global.mapCategoriiByMeniu.get(meniu_id);
                listaVeche.add(category);
                Global.mapCategoriiByMeniu.replace(meniu_id,listaVeche);
            }
            // daca nu exista nicio category in meniu, adaugam noi o lista cu categ noua
            else {
                List<Category> listaVeche = new ArrayList<>();
                listaVeche.add(category);
                Global.mapCategoriiByMeniu.put(meniu_id, listaVeche);
            }
        }

        return "redirect:/vizualizareCategorii/"+meniu_id;
    }

    private List<Category> stergeCategorie(Long meniu_id, Category category) {
        List<Category> listaVeche= Global.mapCategoriiByMeniu.get(meniu_id);
        int sters=0;
        for(int i=0;i<listaVeche.size() && sters==0;i++){
            Category category1 =listaVeche.get(i);
            if(category1.getId().equals(category.getId())){
                listaVeche.remove(i);
                sters=1;
            }
        }
        return listaVeche;
    }


    @RequestMapping(value = "/stergeCategorie/{categorie_id}/{meniu_id}", method = RequestMethod.GET)

    public String stergeMeniu(@PathVariable("categorie_id") Long categorie_id,@PathVariable("meniu_id") Long meniu_id) {
        Category category =categorieService.findById(categorie_id);
        categorieRepository.deleteCategorie(categorie_id);

        List<Category> listaVeche=stergeCategorie(meniu_id, category);
       // List<Category> listaVeche= Global.mapCategoriiByMeniu.get(meniu_id);
        Global.mapCategoriiByMeniu.replace(meniu_id,listaVeche);

        return "redirect:/vizualizareCategorii/"+meniu_id;
    }

    //-------GET LISTA CATEGORII--------
    @RequestMapping(value = "/getCategoriesByIdMenu/{idMenu}", method = RequestMethod.GET)
    @ResponseBody
    public InfoCategoryList getCategoriesByIdMenu(@PathVariable Long idMenu) {
        InfoCategoryList infoCategoryList= new InfoCategoryList();
        List<InfoCategory> categories;
        try{
            categories = categorieService.findAllInfoByMeniuId(idMenu);
            infoCategoryList.setInfoCategoryList(categories);
            infoCategoryList.setResult("OK");
        }
        catch (Exception e){
            infoCategoryList.setResult("ERR");
        }

        return infoCategoryList;
    }
}
