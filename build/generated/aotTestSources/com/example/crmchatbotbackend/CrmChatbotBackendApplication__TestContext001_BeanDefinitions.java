package com.example.crmchatbotbackend;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CrmChatbotBackendApplication}.
 */
@Generated
public class CrmChatbotBackendApplication__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'crmChatbotBackendApplication'.
   */
  public static BeanDefinition getCrmChatbotBackendApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CrmChatbotBackendApplication.class);
    beanDefinition.setInstanceSupplier(CrmChatbotBackendApplication::new);
    return beanDefinition;
  }
}
