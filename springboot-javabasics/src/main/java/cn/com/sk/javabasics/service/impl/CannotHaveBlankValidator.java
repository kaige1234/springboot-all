package cn.com.sk.javabasics.service.impl;

import cn.com.sk.javabasics.annotation.CannotHaveBlank;
import cn.com.sk.javabasics.entity.GroupVolidation;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class CannotHaveBlankValidator implements ConstraintValidator<CannotHaveBlank, Object> {
    @Override
    public void initialize(CannotHaveBlank constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        GroupVolidation cannotHaveBlank = (GroupVolidation) o;//getConstraintDescriptor
        //ConstraintValidatorContextImpl
        ConstraintValidatorContextImpl constraintValidatorContextImp = (ConstraintValidatorContextImpl)constraintValidatorContext;
        ConstraintDescriptor<?> constraintDescriptor = constraintValidatorContextImp.getConstraintDescriptor();
        Map<String, Object> attributes = constraintDescriptor.getAttributes();

        //(ConstraintValidatorContextImpl)constraintValidatorContext.getDefaultConstraintMessageTemplate();
        //constraintValidatorContext.buildConstraintViolationWithTemplate()
        return true;
    }


}

