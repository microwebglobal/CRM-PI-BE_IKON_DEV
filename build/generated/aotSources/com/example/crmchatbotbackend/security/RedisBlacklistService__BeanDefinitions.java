package com.example.crmchatbotbackend.security;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Bean definitions for {@link RedisBlacklistService}.
 */
@Generated
public class RedisBlacklistService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'redisBlacklistService'.
   */
  private static BeanInstanceSupplier<RedisBlacklistService> getRedisBlacklistServiceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<RedisBlacklistService>forConstructor(StringRedisTemplate.class)
            .withGenerator((registeredBean, args) -> new RedisBlacklistService(args.get(0)));
  }

  /**
   * Get the bean definition for 'redisBlacklistService'.
   */
  public static BeanDefinition getRedisBlacklistServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedisBlacklistService.class);
    beanDefinition.setInstanceSupplier(getRedisBlacklistServiceInstanceSupplier());
    return beanDefinition;
  }
}
