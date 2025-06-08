package org.springdoc.core.configuration;

import org.springdoc.core.customizers.ParameterCustomizer;
import org.springdoc.core.parsers.KotlinCoroutinesReturnTypeParser;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SpringDocKotlinConfiguration}.
 */
@Generated
public class SpringDocKotlinConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'springDocKotlinConfiguration'.
   */
  public static BeanDefinition getSpringDocKotlinConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocKotlinConfiguration.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(SpringDocKotlinConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'kotlinCoroutinesReturnTypeParser'.
   */
  private static BeanInstanceSupplier<KotlinCoroutinesReturnTypeParser> getKotlinCoroutinesReturnTypeParserInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<KotlinCoroutinesReturnTypeParser>forFactoryMethod(SpringDocKotlinConfiguration.class, "kotlinCoroutinesReturnTypeParser")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springdoc.core.configuration.SpringDocKotlinConfiguration", SpringDocKotlinConfiguration.class).kotlinCoroutinesReturnTypeParser());
  }

  /**
   * Get the bean definition for 'kotlinCoroutinesReturnTypeParser'.
   */
  public static BeanDefinition getKotlinCoroutinesReturnTypeParserBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(KotlinCoroutinesReturnTypeParser.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setFactoryBeanName("org.springdoc.core.configuration.SpringDocKotlinConfiguration");
    beanDefinition.setInstanceSupplier(getKotlinCoroutinesReturnTypeParserInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'nullableKotlinRequestParameterCustomizer'.
   */
  private static BeanInstanceSupplier<ParameterCustomizer> getNullableKotlinRequestParameterCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<ParameterCustomizer>forFactoryMethod(SpringDocKotlinConfiguration.class, "nullableKotlinRequestParameterCustomizer")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("org.springdoc.core.configuration.SpringDocKotlinConfiguration", SpringDocKotlinConfiguration.class).nullableKotlinRequestParameterCustomizer());
  }

  /**
   * Get the bean definition for 'nullableKotlinRequestParameterCustomizer'.
   */
  public static BeanDefinition getNullableKotlinRequestParameterCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ParameterCustomizer.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setFactoryBeanName("org.springdoc.core.configuration.SpringDocKotlinConfiguration");
    beanDefinition.setInstanceSupplier(getNullableKotlinRequestParameterCustomizerInstanceSupplier());
    return beanDefinition;
  }
}
