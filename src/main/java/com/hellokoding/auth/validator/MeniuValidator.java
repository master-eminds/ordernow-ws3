package com.hellokoding.auth.validator;

import com.hellokoding.auth.model.Menu;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MeniuValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Menu.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Menu menu = (Menu) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "denumire", "NotEmpty");

    /*    if (menu.getStare().equals("0")) {
            errors.rejectValue("stare", "Select.meniuForm.stare");
        }*/
     /*   if (menu.getImage()==null|| menu.getImage().length==0|| menu.getImage().toString().isEmpty()) {
            errors.rejectValue("image", "Empty.meniuForm.image");
        }*/
    }
}

