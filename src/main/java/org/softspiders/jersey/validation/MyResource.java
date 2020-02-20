package org.softspiders.jersey.validation;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8") // might be overridden on an application method level
    @Consumes(MediaType.TEXT_PLAIN + ";charset=utf-8")
    public String getIt(@NotBlank @QueryParam("input") String input, @Pattern(regexp = "123", message = "wrong pattern") @QueryParam("pattern") String pattern) {
        return "This is your input: " + input;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN + ";charset=utf-8") // might be overridden on an application method level
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String getItSecret(@Valid Dto dto) {
        return "This is your input: " + dto.getInput() + " and secret input: " + dto.getSecretInput();
    }
}