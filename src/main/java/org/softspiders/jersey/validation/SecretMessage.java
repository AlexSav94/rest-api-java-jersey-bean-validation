package org.softspiders.jersey.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = SecretValidator.class)
public @interface SecretMessage {

  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

  String password();
  String message() default "wrong password";
}
