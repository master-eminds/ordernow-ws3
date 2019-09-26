package com.hellokoding.auth.validator;

import com.hellokoding.auth.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProdusValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "denumire", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gramaj", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ingrediente", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descriere", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pret", "NotEmpty");

        String ingrediente= product.getIngrediente();
        boolean gresit=false;
        if(ingrediente.length()>=2){
            if(!ingrediente.substring(0,1).equals("(")){
                gresit=true;
            }
            else if (!ingrediente.substring(ingrediente.length()-1).equals(")")){
                gresit=true;
            }
            else if(ingrediente.contains(";")){
                gresit=true;
            }
            else if(ingrediente.contains(".")){
                gresit=true;
            }
        }
        if (gresit) {
            errors.rejectValue("ingrediente", "Format.produsForm.ingrediente");
        }
        if (product.getVizibilitate().equals("0")) {
            errors.rejectValue("vizibilitate", "Select.categorieForm.vizibilitate");
        }
        if (product.getImagine()==null|| product.getImagine().length==0|| product.getImagine().toString().isEmpty()) {
            errors.rejectValue("imagine", "Empty.meniuForm.image");
        }
    }

}
