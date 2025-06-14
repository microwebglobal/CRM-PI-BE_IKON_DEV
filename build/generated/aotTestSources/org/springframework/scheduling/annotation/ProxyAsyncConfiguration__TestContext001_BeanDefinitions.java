package org.springframework.scheduling.annotation;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ProxyAsyncConfiguration}.
 */
@Generated
public class ProxyAsyncConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'proxyAsyncConfiguration'.
   */
  public static BeanDefinition getProxyAsyncConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ProxyAsyncConfiguration.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    InstanceSupplier<ProxyAsyncConfiguration> instanceSupplier = InstanceSupplier.using(ProxyAsyncConfiguration::new);
    instanceSupplier = instanceSupplier.andThen(ProxyAsyncConfiguration__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'org.springframework.context.annotation.internalAsyncAnnotationProcessor'.
   */
  private static BeanInstanceSupplier<AsyncAnnotationBeanPostProcessor> getInternalAsyncAnnotationProcessorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AsyncAnnotationBeanPostProcessor>forFactoryMethod(ProxyAsyncConfiguration.class, "asyncAdvisor")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springframework.scheduling.annotation.ProxyAsyncConfiguration", ProxyAsyncConfiguration.class).asyncAdvisor());
  }

  /**
   * Get the bean definition for 'internalAsyncAnnotationProcessor'.
   */
  public static BeanDefinition getInternalAsyncAnnotationProcessorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AsyncAnnotationBeanPostProcessor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setFactoryBeanName("org.springframework.scheduling.annotation.ProxyAsyncConfiguration");
    beanDefinition.setInstanceSupplier(getInternalAsyncAnnotationProcessorInstanceSupplier());
    return beanDefinition;
  }
}
