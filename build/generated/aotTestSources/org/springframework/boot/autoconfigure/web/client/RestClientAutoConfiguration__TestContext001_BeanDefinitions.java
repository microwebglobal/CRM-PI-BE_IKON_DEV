package org.springframework.boot.autoconfigure.web.client;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.web.client.RestClient;

/**
 * Bean definitions for {@link RestClientAutoConfiguration}.
 */
@Generated
public class RestClientAutoConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'restClientAutoConfiguration'.
   */
  public static BeanDefinition getRestClientAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RestClientAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(RestClientAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'httpMessageConvertersRestClientCustomizer'.
   */
  private static BeanInstanceSupplier<HttpMessageConvertersRestClientCustomizer> getHttpMessageConvertersRestClientCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<HttpMessageConvertersRestClientCustomizer>forFactoryMethod(RestClientAutoConfiguration.class, "httpMessageConvertersRestClientCustomizer", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration", RestClientAutoConfiguration.class).httpMessageConvertersRestClientCustomizer(args.get(0)));
  }

  /**
   * Get the bean definition for 'httpMessageConvertersRestClientCustomizer'.
   */
  public static BeanDefinition getHttpMessageConvertersRestClientCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(HttpMessageConvertersRestClientCustomizer.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration");
    beanDefinition.setInstanceSupplier(getHttpMessageConvertersRestClientCustomizerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'restClientSsl'.
   */
  private static BeanInstanceSupplier<AutoConfiguredRestClientSsl> getRestClientSslInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AutoConfiguredRestClientSsl>forFactoryMethod(RestClientAutoConfiguration.class, "restClientSsl", ObjectProvider.class, ObjectProvider.class, SslBundles.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration", RestClientAutoConfiguration.class).restClientSsl(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'restClientSsl'.
   */
  public static BeanDefinition getRestClientSslBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AutoConfiguredRestClientSsl.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration");
    beanDefinition.setInstanceSupplier(getRestClientSslInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'restClientBuilderConfigurer'.
   */
  private static BeanInstanceSupplier<RestClientBuilderConfigurer> getRestClientBuilderConfigurerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RestClientBuilderConfigurer>forFactoryMethod(RestClientAutoConfiguration.class, "restClientBuilderConfigurer", ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration", RestClientAutoConfiguration.class).restClientBuilderConfigurer(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'restClientBuilderConfigurer'.
   */
  public static BeanDefinition getRestClientBuilderConfigurerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RestClientBuilderConfigurer.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration");
    beanDefinition.setInstanceSupplier(getRestClientBuilderConfigurerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'restClientBuilder'.
   */
  private static BeanInstanceSupplier<RestClient.Builder> getRestClientBuilderInstanceSupplier() {
    return BeanInstanceSupplier.<RestClient.Builder>forFactoryMethod(RestClientAutoConfiguration.class, "restClientBuilder", RestClientBuilderConfigurer.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration", RestClientAutoConfiguration.class).restClientBuilder(args.get(0)));
  }

  /**
   * Get the bean definition for 'restClientBuilder'.
   */
  public static BeanDefinition getRestClientBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RestClient.Builder.class);
    beanDefinition.setScope("prototype");
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.web.client.RestClientAutoConfiguration");
    beanDefinition.setInstanceSupplier(getRestClientBuilderInstanceSupplier());
    return beanDefinition;
  }
}
