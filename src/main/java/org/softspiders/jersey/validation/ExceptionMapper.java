package org.softspiders.jersey.validation;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import java.util.Iterator;
import java.util.Set;

public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<ValidationException> {
  @Override
  public Response toResponse(ValidationException e) {
    if (e instanceof ConstraintViolationException) {
      ConstraintViolationException ex = (ConstraintViolationException) e;
      Set<ConstraintViolation<?>> errors = ex.getConstraintViolations();
      String result = "";
      for (ConstraintViolation error : errors) {
        result += error.getMessage();
      }
      return Response.serverError().entity(result).build();
    }
    return Response.serverError().entity(e.getMessage()).build();
  }
}
