package com.example.crmchatbotbackend.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link LeadController}.
 */
@Generated
public class LeadController__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'leadController'.
   */
  public static BeanDefinition getLeadControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LeadController.class);
    InstanceSupplier<LeadController> instanceSupplier = InstanceSupplier.using(LeadController::new);
    instanceSupplier = instanceSupplier.andThen(LeadController__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
