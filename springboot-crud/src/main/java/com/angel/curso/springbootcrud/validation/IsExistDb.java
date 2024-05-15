package com.angel.curso.springbootcrud.validation;

import jakarta.validation.*;
import java.lang.annotation.*;

@Constraint(validatedBy = IsExistDbValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsExistDb {
    String message() default "ya existe en DB, recuerda usar anotaciones";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
