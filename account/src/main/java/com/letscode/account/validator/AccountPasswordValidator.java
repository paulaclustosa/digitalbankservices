package com.letscode.account.validator;

import com.letscode.account.annotation.AccountPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountPasswordValidator implements ConstraintValidator<AccountPassword, Integer> {
  @Override
  public void initialize(AccountPassword constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
    return Integer.toString(value).length() == 6;
  }
}
