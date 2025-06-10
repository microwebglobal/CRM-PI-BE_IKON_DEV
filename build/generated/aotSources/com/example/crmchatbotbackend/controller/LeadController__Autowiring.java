package com.example.crmchatbotbackend.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link LeadController}.
 */
@Generated
public class LeadController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static LeadController apply(RegisteredBean registeredBean, LeadController instance) {
    AutowiredFieldValueResolver.forRequiredField("leadRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
