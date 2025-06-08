package com.vaadin.flow.spring;

import com.vaadin.flow.server.auth.AccessAnnotationChecker;
import com.vaadin.flow.server.auth.AccessPathChecker;
import com.vaadin.flow.server.auth.AnnotatedViewAccessChecker;
import com.vaadin.flow.server.auth.NavigationAccessControl;
import com.vaadin.flow.server.auth.RoutePathAccessChecker;
import com.vaadin.flow.spring.security.NavigationAccessControlConfigurer;
import com.vaadin.flow.spring.security.NavigationAccessControlInitializer;
import com.vaadin.flow.spring.security.RequestUtil;
import com.vaadin.flow.spring.security.RequestUtil__Autowiring;
import com.vaadin.flow.spring.security.VaadinDefaultRequestCache;
import com.vaadin.flow.spring.security.VaadinDefaultRequestCache__Autowiring;
import com.vaadin.flow.spring.security.VaadinRolePrefixHolder;
import java.util.List;
import java.util.Optional;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;

/**
 * Bean definitions for {@link SpringSecurityAutoConfiguration}.
 */
@Generated
public class SpringSecurityAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'springSecurityAutoConfiguration'.
   */
  public static BeanDefinition getSpringSecurityAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringSecurityAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(SpringSecurityAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'vaadinDefaultRequestCache'.
   */
  private static BeanInstanceSupplier<VaadinDefaultRequestCache> getVaadinDefaultRequestCacheInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<VaadinDefaultRequestCache>forFactoryMethod(SpringSecurityAutoConfiguration.class, "vaadinDefaultRequestCache")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("com.vaadin.flow.spring.SpringSecurityAutoConfiguration", SpringSecurityAutoConfiguration.class).vaadinDefaultRequestCache());
  }

  /**
   * Get the bean definition for 'vaadinDefaultRequestCache'.
   */
  public static BeanDefinition getVaadinDefaultRequestCacheBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VaadinDefaultRequestCache.class);
    beanDefinition.setFactoryBeanName("com.vaadin.flow.spring.SpringSecurityAutoConfiguration");
    InstanceSupplier<VaadinDefaultRequestCache> instanceSupplier = getVaadinDefaultRequestCacheInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(VaadinDefaultRequestCache__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'navigationAccessControlInitializer'.
   */
  private static BeanInstanceSupplier<NavigationAccessControlInitializer> getNavigationAccessControlInitializerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<NavigationAccessControlInitializer>forFactoryMethod(SpringSecurityAutoConfiguration.class, "navigationAccessControlInitializer", NavigationAccessControl.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("com.vaadin.flow.spring.SpringSecurityAutoConfiguration", SpringSecurityAutoConfiguration.class).navigationAccessControlInitializer(args.get(0)));
  }

  /**
   * Get the bean definition for 'navigationAccessControlInitializer'.
   */
  public static BeanDefinition getNavigationAccessControlInitializerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NavigationAccessControlInitializer.class);
    beanDefinition.setFactoryBeanName("com.vaadin.flow.spring.SpringSecurityAutoConfiguration");
    beanDefinition.setInstanceSupplier(getNavigationAccessControlInitializerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'navigationAccessControl'.
   */
  private static BeanInstanceSupplier<NavigationAccessControl> getNavigationAccessControlInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<NavigationAccessControl>forFactoryMethod(SpringSecurityAutoConfiguration.class, "navigationAccessControl", List.class, NavigationAccessControlConfigurer.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("com.vaadin.flow.spring.SpringSecurityAutoConfiguration", SpringSecurityAutoConfiguration.class).navigationAccessControl(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'navigationAccessControl'.
   */
  public static BeanDefinition getNavigationAccessControlBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NavigationAccessControl.class);
    beanDefinition.setFactoryBeanName("com.vaadin.flow.spring.SpringSecurityAutoConfiguration");
    beanDefinition.setInstanceSupplier(getNavigationAccessControlInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'navigationAccessControlConfigurerCustomizer'.
   */
  private static BeanInstanceSupplier<NavigationAccessControlConfigurer> getNavigationAccessControlConfigurerCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<NavigationAccessControlConfigurer>forFactoryMethod(SpringSecurityAutoConfiguration.class, "navigationAccessControlConfigurerCustomizer")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("com.vaadin.flow.spring.SpringSecurityAutoConfiguration", SpringSecurityAutoConfiguration.class).navigationAccessControlConfigurerCustomizer());
  }

  /**
   * Get the bean definition for 'navigationAccessControlConfigurerCustomizer'.
   */
  public static BeanDefinition getNavigationAccessControlConfigurerCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(NavigationAccessControlConfigurer.class);
    beanDefinition.setFactoryBeanName("com.vaadin.flow.spring.SpringSecurityAutoConfiguration");
    beanDefinition.setInstanceSupplier(getNavigationAccessControlConfigurerCustomizerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'annotatedViewAccessChecker'.
   */
  private static BeanInstanceSupplier<AnnotatedViewAccessChecker> getAnnotatedViewAccessCheckerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AnnotatedViewAccessChecker>forFactoryMethod(SpringSecurityAutoConfiguration.class, "annotatedViewAccessChecker", AccessAnnotationChecker.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("com.vaadin.flow.spring.SpringSecurityAutoConfiguration", SpringSecurityAutoConfiguration.class).annotatedViewAccessChecker(args.get(0)));
  }

  /**
   * Get the bean definition for 'annotatedViewAccessChecker'.
   */
  public static BeanDefinition getAnnotatedViewAccessCheckerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AnnotatedViewAccessChecker.class);
    beanDefinition.setFactoryBeanName("com.vaadin.flow.spring.SpringSecurityAutoConfiguration");
    beanDefinition.setInstanceSupplier(getAnnotatedViewAccessCheckerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'routePathAccessChecker'.
   */
  private static BeanInstanceSupplier<RoutePathAccessChecker> getRoutePathAccessCheckerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RoutePathAccessChecker>forFactoryMethod(SpringSecurityAutoConfiguration.class, "routePathAccessChecker", AccessPathChecker.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("com.vaadin.flow.spring.SpringSecurityAutoConfiguration", SpringSecurityAutoConfiguration.class).routePathAccessChecker(args.get(0)));
  }

  /**
   * Get the bean definition for 'routePathAccessChecker'.
   */
  public static BeanDefinition getRoutePathAccessCheckerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RoutePathAccessChecker.class);
    beanDefinition.setFactoryBeanName("com.vaadin.flow.spring.SpringSecurityAutoConfiguration");
    beanDefinition.setInstanceSupplier(getRoutePathAccessCheckerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'accessPatchChecker'.
   */
  private static BeanInstanceSupplier<AccessPathChecker> getAccessPatchCheckerInstanceSupplier() {
    return BeanInstanceSupplier.<AccessPathChecker>forFactoryMethod(SpringSecurityAutoConfiguration.class, "accessPatchChecker", VaadinConfigurationProperties.class, WebInvocationPrivilegeEvaluator.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("com.vaadin.flow.spring.SpringSecurityAutoConfiguration", SpringSecurityAutoConfiguration.class).accessPatchChecker(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'accessPatchChecker'.
   */
  public static BeanDefinition getAccessPatchCheckerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AccessPathChecker.class);
    beanDefinition.setFactoryBeanName("com.vaadin.flow.spring.SpringSecurityAutoConfiguration");
    beanDefinition.setInstanceSupplier(getAccessPatchCheckerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'accessAnnotationChecker'.
   */
  private static BeanInstanceSupplier<AccessAnnotationChecker> getAccessAnnotationCheckerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AccessAnnotationChecker>forFactoryMethod(SpringSecurityAutoConfiguration.class, "accessAnnotationChecker")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("com.vaadin.flow.spring.SpringSecurityAutoConfiguration", SpringSecurityAutoConfiguration.class).accessAnnotationChecker());
  }

  /**
   * Get the bean definition for 'accessAnnotationChecker'.
   */
  public static BeanDefinition getAccessAnnotationCheckerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AccessAnnotationChecker.class);
    beanDefinition.setFactoryBeanName("com.vaadin.flow.spring.SpringSecurityAutoConfiguration");
    beanDefinition.setInstanceSupplier(getAccessAnnotationCheckerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'requestUtil'.
   */
  private static BeanInstanceSupplier<RequestUtil> getRequestUtilInstanceSupplier() {
    return BeanInstanceSupplier.<RequestUtil>forFactoryMethod(SpringSecurityAutoConfiguration.class, "requestUtil")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean("com.vaadin.flow.spring.SpringSecurityAutoConfiguration", SpringSecurityAutoConfiguration.class).requestUtil());
  }

  /**
   * Get the bean definition for 'requestUtil'.
   */
  public static BeanDefinition getRequestUtilBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RequestUtil.class);
    beanDefinition.setFactoryBeanName("com.vaadin.flow.spring.SpringSecurityAutoConfiguration");
    InstanceSupplier<RequestUtil> instanceSupplier = getRequestUtilInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(RequestUtil__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'vaadinRolePrefixHolder'.
   */
  private static BeanInstanceSupplier<VaadinRolePrefixHolder> getVaadinRolePrefixHolderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<VaadinRolePrefixHolder>forFactoryMethod(SpringSecurityAutoConfiguration.class, "vaadinRolePrefixHolder", Optional.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("com.vaadin.flow.spring.SpringSecurityAutoConfiguration", SpringSecurityAutoConfiguration.class).vaadinRolePrefixHolder(args.get(0)));
  }

  /**
   * Get the bean definition for 'vaadinRolePrefixHolder'.
   */
  public static BeanDefinition getVaadinRolePrefixHolderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(VaadinRolePrefixHolder.class);
    beanDefinition.setFactoryBeanName("com.vaadin.flow.spring.SpringSecurityAutoConfiguration");
    beanDefinition.setInstanceSupplier(getVaadinRolePrefixHolderInstanceSupplier());
    return beanDefinition;
  }
}
