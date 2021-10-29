package cn.com.sk.javabasics.service.impl;

import cn.com.sk.javabasics.annotation.CustomValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CustomValidationImpl implements ConstraintValidator<CustomValidation,String> {

    @Override
    public void initialize(CustomValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
