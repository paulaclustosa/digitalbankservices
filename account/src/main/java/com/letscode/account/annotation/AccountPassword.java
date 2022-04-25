package com.letscode.account.annotation;

import com.letscode.account.validator.AccountPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AccountPasswordValidator.class)
public @interface AccountPassword {
  String message() default "Account password must be a four digits number.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
