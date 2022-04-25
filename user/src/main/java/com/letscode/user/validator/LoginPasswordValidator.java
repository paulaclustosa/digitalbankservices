package com.letscode.user.validator;

import com.letscode.user.annotation.LoginPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginPasswordValidator implements ConstraintValidator<LoginPassword, Integer> {

  @Override
  public void initialize(LoginPassword constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
    return Integer.toString(value).length() == 8;
  }
}
