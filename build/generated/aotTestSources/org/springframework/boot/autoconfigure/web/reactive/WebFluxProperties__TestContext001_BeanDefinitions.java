package org.springframework.boot.autoconfigure.web.reactive;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link WebFluxProperties}.
 */
@Generated
public class WebFluxProperties__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'webFluxProperties'.
   */
  public static BeanDefinition getWebFluxPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(WebFluxProperties.class);
    beanDefinition.setInstanceSupplier(WebFluxProperties::new);
    return beanDefinition;
  }
}
