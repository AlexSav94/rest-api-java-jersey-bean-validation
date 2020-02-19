package org.softspiders.jersey.validation;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public class Application extends ResourceConfig {

  public Application() {
    register(MyResource.class);
    property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    register(ExceptionMapper.class);
  }
}
