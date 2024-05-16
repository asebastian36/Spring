package com.angel.curso.springbootcrud;

import com.angel.curso.springbootcrud.entities.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;

@Component
public class ProductValidation implements Validator {
    //  clase para validar de manera personalizada
    @Override
    public boolean supports(Class<?> clazz) {
        //  metodo para especificar el objeto a validar
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //  aqui se hace la validacion target es el objeto a validar y errors es padre de BindingResult
        Product product = (Product) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "no puede estar vacio, acaso no tienes nombre!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", null, "no puede estar vacio, acaso no tiene descripcion!");

        if (product.getPrice() < 100 ) {
            errors.rejectValue("price", null, "tiene que ser mayor o igual a 100 paka!");
        } else if (product.getPrice() == 0) {
            errors.rejectValue("price", null, "no puede ser nulo, como lo vas a vender!");
        }
    }
}
