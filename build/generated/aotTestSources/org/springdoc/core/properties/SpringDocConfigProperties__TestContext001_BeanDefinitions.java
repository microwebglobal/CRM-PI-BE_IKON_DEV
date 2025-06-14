package org.springdoc.core.properties;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SpringDocConfigProperties}.
 */
@Generated
public class SpringDocConfigProperties__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'springDocConfigProperties'.
   */
  public static BeanDefinition getSpringDocConfigPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocConfigProperties.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(SpringDocConfigProperties::new);
    return beanDefinition;
  }
}
