package com.hellokoding.auth.validator;

import com.hellokoding.auth.model.Category;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CategorieValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Category.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Category category = (Category) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "denumire", "NotEmpty");

        if (!category.getVizibilitate().equals("vizibil")&&!category.getVizibilitate().equals("invizibil")) {
            errors.rejectValue("vizibilitate", "Select.categorieForm.vizibilitate");
        }
        if (category.getImagine()==null|| category.getImagine().length==0|| category.getImagine().toString().isEmpty()) {
            errors.rejectValue("imagine", "Empty.meniuForm.image");
        }
    }

}
