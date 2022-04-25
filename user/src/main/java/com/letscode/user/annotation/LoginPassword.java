package com.letscode.user.annotation;

import com.letscode.user.validator.LoginPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LoginPasswordValidator.class)
public @interface LoginPassword {
  String message() default "Login password must be an eight digits number.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
