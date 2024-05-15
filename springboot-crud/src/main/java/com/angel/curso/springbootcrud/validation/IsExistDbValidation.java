package com.angel.curso.springbootcrud.validation;

import com.angel.curso.springbootcrud.services.ProductService;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class IsExistDbValidation implements ConstraintValidator<IsExistDb, String> {

    @Autowired
    private ProductService service;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (service != null) return !service.existsBySku(s);
        return true;
    }
}
