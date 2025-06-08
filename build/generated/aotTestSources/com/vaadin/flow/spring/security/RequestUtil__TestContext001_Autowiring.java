package com.vaadin.flow.spring.security;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link RequestUtil}.
 */
@Generated
public class RequestUtil__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static RequestUtil apply(RegisteredBean registeredBean, RequestUtil instance) {
    AutowiredFieldValueResolver.forRequiredField("accessControl").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("configurationProperties").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forField("endpointRequestUtil").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forField("fileRouterRequestUtil").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("springServletRegistration").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
