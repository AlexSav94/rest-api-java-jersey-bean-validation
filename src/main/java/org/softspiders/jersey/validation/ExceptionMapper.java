package org.softspiders.jersey.validation;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import java.util.Iterator;
import java.util.Set;

public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<ConstraintViolationException> {
  @Override
  public Response toResponse(ConstraintViolationException e) {
    Set<ConstraintViolation<?>> errors = e.getConstraintViolations();
    String result = "";
    for (ConstraintViolation error: errors) {
      result += error.getMessage();
    }
    return Response.serverError().entity(result).build();
  }
}
