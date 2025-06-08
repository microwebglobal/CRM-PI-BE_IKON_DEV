package com.example.crmchatbotbackend.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link OpenAPIConfig}.
 */
@Generated
public class OpenAPIConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'openAPIConfig'.
   */
  public static BeanDefinition getOpenAPIConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OpenAPIConfig.class);
    beanDefinition.setTargetType(OpenAPIConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(OpenAPIConfig.class);
    beanDefinition.setInstanceSupplier(OpenAPIConfig$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'apiInfo'.
   */
  private static BeanInstanceSupplier<OpenAPI> getApiInfoInstanceSupplier() {
    return BeanInstanceSupplier.<OpenAPI>forFactoryMethod(OpenAPIConfig$$SpringCGLIB$$0.class, "apiInfo")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("openAPIConfig", OpenAPIConfig.class).apiInfo());
  }

  /**
   * Get the bean definition for 'apiInfo'.
   */
  public static BeanDefinition getApiInfoBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OpenAPI.class);
    beanDefinition.setScope("prototype");
    beanDefinition.setFactoryBeanName("openAPIConfig");
    beanDefinition.setInstanceSupplier(getApiInfoInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'publicApi'.
   */
  private static BeanInstanceSupplier<GroupedOpenApi> getPublicApiInstanceSupplier() {
    return BeanInstanceSupplier.<GroupedOpenApi>forFactoryMethod(OpenAPIConfig$$SpringCGLIB$$0.class, "publicApi")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("openAPIConfig", OpenAPIConfig.class).publicApi());
  }

  /**
   * Get the bean definition for 'publicApi'.
   */
  public static BeanDefinition getPublicApiBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GroupedOpenApi.class);
    beanDefinition.setFactoryBeanName("openAPIConfig");
    beanDefinition.setInstanceSupplier(getPublicApiInstanceSupplier());
    return beanDefinition;
  }
}
