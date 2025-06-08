package org.springdoc.core.configuration;

import org.springdoc.core.converters.SortOpenAPIConverter;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SpringDocSortConfiguration}.
 */
@Generated
public class SpringDocSortConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'springDocSortConfiguration'.
   */
  public static BeanDefinition getSpringDocSortConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocSortConfiguration.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(SpringDocSortConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'sortOpenAPIConverter'.
   */
  private static BeanInstanceSupplier<SortOpenAPIConverter> getSortOpenAPIConverterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SortOpenAPIConverter>forFactoryMethod(SpringDocSortConfiguration.class, "sortOpenAPIConverter", ObjectMapperProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springdoc.core.configuration.SpringDocSortConfiguration", SpringDocSortConfiguration.class).sortOpenAPIConverter(args.get(0)));
  }

  /**
   * Get the bean definition for 'sortOpenAPIConverter'.
   */
  public static BeanDefinition getSortOpenAPIConverterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SortOpenAPIConverter.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setFactoryBeanName("org.springdoc.core.configuration.SpringDocSortConfiguration");
    beanDefinition.setInstanceSupplier(getSortOpenAPIConverterInstanceSupplier());
    return beanDefinition;
  }
}
