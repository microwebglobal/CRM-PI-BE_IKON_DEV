package org.springdoc.webmvc.core.configuration;

import java.util.List;
import org.springdoc.core.customizers.SpringDocCustomizers;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.providers.SpringDocProviders;
import org.springdoc.core.service.AbstractRequestService;
import org.springdoc.core.service.GenericResponseService;
import org.springdoc.core.service.OperationService;
import org.springdoc.webmvc.api.MultipleOpenApiWebMvcResource;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MultipleOpenApiSupportConfiguration}.
 */
@Generated
public class MultipleOpenApiSupportConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'multipleOpenApiSupportConfiguration'.
   */
  public static BeanDefinition getMultipleOpenApiSupportConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MultipleOpenApiSupportConfiguration.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(MultipleOpenApiSupportConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'multipleOpenApiResource'.
   */
  private static BeanInstanceSupplier<MultipleOpenApiWebMvcResource> getMultipleOpenApiResourceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MultipleOpenApiWebMvcResource>forFactoryMethod(MultipleOpenApiSupportConfiguration.class, "multipleOpenApiResource", List.class, ObjectFactory.class, AbstractRequestService.class, GenericResponseService.class, OperationService.class, SpringDocConfigProperties.class, SpringDocProviders.class, SpringDocCustomizers.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springdoc.webmvc.core.configuration.MultipleOpenApiSupportConfiguration", MultipleOpenApiSupportConfiguration.class).multipleOpenApiResource(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6), args.get(7)));
  }

  /**
   * Get the bean definition for 'multipleOpenApiResource'.
   */
  public static BeanDefinition getMultipleOpenApiResourceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MultipleOpenApiWebMvcResource.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setFactoryBeanName("org.springdoc.webmvc.core.configuration.MultipleOpenApiSupportConfiguration");
    beanDefinition.setInstanceSupplier(getMultipleOpenApiResourceInstanceSupplier());
    return beanDefinition;
  }
}
