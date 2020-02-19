package org.softspiders.jersey.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SecretValidator implements ConstraintValidator<SecretMessage, Dto> {

  private String password;

  @Override
  public void initialize(SecretMessage constraintAnnotation) {
    password = constraintAnnotation.password();
  }

  @Override
  public boolean isValid(Dto dto, ConstraintValidatorContext constraintValidatorContext) {
    return password.equals(dto.getPassword()) && dto.getSecretInput() != null;
  }
}
