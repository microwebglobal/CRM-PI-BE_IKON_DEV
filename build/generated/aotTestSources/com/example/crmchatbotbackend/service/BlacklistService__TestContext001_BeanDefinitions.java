package com.example.crmchatbotbackend.service;

import com.example.crmchatbotbackend.repository.BlacklistedTokenRepository;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link BlacklistService}.
 */
@Generated
public class BlacklistService__TestContext001_BeanDefinitions {
  /**
   * Get the bean instance supplier for 'blacklistService'.
   */
  private static BeanInstanceSupplier<BlacklistService> getBlacklistServiceInstanceSupplier() {
    return BeanInstanceSupplier.<BlacklistService>forConstructor(BlacklistedTokenRepository.class)
            .withGenerator((registeredBean, args) -> new BlacklistService(args.get(0)));
  }

  /**
   * Get the bean definition for 'blacklistService'.
   */
  public static BeanDefinition getBlacklistServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(BlacklistService.class);
    beanDefinition.setInstanceSupplier(getBlacklistServiceInstanceSupplier());
    return beanDefinition;
  }
}
