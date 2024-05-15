package com.angel.curso.springbootcrud.validation;

import jakarta.validation.*;
import java.lang.annotation.*;

@Constraint(validatedBy = RequiredValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface IsRequired {
    String message() default "es requerido, recuerda usar anotaciones";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
