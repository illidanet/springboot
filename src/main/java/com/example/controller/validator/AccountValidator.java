package com.example.controller.validator;

import com.example.controller.form.AccountForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by illidanet on 3/3/17.
 */
public class AccountValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {

        return AccountForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.
    }
}
