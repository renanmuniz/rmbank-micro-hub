package com.rmbank.microhub.v1.hexagono.dominio;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class Validador {
    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> void validar(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> violations = validator.validate(object, groups);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
