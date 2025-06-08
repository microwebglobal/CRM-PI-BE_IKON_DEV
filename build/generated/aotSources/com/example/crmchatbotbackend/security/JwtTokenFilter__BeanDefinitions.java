package com.example.crmchatbotbackend.security;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Bean definitions for {@link JwtTokenFilter}.
 */
@Generated
public class JwtTokenFilter__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'jwtTokenFilter'.
   */
  private static BeanInstanceSupplier<JwtTokenFilter> getJwtTokenFilterInstanceSupplier() {
    return BeanInstanceSupplier.<JwtTokenFilter>forConstructor(JwtUtil.class, UserDetailsService.class)
            .withGenerator((registeredBean, args) -> new JwtTokenFilter(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'jwtTokenFilter'.
   */
  public static BeanDefinition getJwtTokenFilterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JwtTokenFilter.class);
    beanDefinition.setInstanceSupplier(getJwtTokenFilterInstanceSupplier());
    return beanDefinition;
  }
}
