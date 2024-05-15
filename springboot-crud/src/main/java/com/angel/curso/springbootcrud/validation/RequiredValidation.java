package com.angel.curso.springbootcrud.validation;

import jakarta.validation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class RequiredValidation implements ConstraintValidator<IsRequired, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
//        if (s != null && !s.isEmpty() && !s.isBlank()) return true;
//        return false;
        return StringUtils.hasText(s);
    }
}
