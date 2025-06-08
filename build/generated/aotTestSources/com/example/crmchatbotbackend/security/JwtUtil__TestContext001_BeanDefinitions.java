package com.example.crmchatbotbackend.security;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JwtUtil}.
 */
@Generated
public class JwtUtil__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'jwtUtil'.
   */
  public static BeanDefinition getJwtUtilBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JwtUtil.class);
    beanDefinition.setInstanceSupplier(JwtUtil::new);
    return beanDefinition;
  }
}
