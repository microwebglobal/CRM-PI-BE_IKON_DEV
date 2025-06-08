package com.vaadin.flow.spring.security;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link VaadinDefaultRequestCache}.
 */
@Generated
public class VaadinDefaultRequestCache__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static VaadinDefaultRequestCache apply(RegisteredBean registeredBean,
      VaadinDefaultRequestCache instance) {
    AutowiredFieldValueResolver.forRequiredField("requestUtil").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("configuredErrorPath").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
