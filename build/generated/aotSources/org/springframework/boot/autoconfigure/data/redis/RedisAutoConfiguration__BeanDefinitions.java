package org.springframework.boot.autoconfigure.data.redis;

import java.lang.Object;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Bean definitions for {@link RedisAutoConfiguration}.
 */
@Generated
public class RedisAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'redisAutoConfiguration'.
   */
  public static BeanDefinition getRedisAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedisAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(RedisAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'redisConnectionDetails'.
   */
  private static BeanInstanceSupplier<PropertiesRedisConnectionDetails> getRedisConnectionDetailsInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PropertiesRedisConnectionDetails>forFactoryMethod(RedisAutoConfiguration.class, "redisConnectionDetails", RedisProperties.class, ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration", RedisAutoConfiguration.class).redisConnectionDetails(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'redisConnectionDetails'.
   */
  public static BeanDefinition getRedisConnectionDetailsBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PropertiesRedisConnectionDetails.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration");
    beanDefinition.setInstanceSupplier(getRedisConnectionDetailsInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'redisTemplate'.
   */
  private static BeanInstanceSupplier<RedisTemplate> getRedisTemplateInstanceSupplier() {
    return BeanInstanceSupplier.<RedisTemplate>forFactoryMethod(RedisAutoConfiguration.class, "redisTemplate", RedisConnectionFactory.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration", RedisAutoConfiguration.class).redisTemplate(args.get(0)));
  }

  /**
   * Get the bean definition for 'redisTemplate'.
   */
  public static BeanDefinition getRedisTemplateBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(RedisTemplate.class);
    beanDefinition.setTargetType(ResolvableType.forClassWithGenerics(RedisTemplate.class, Object.class, Object.class));
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration");
    beanDefinition.setInstanceSupplier(getRedisTemplateInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'stringRedisTemplate'.
   */
  private static BeanInstanceSupplier<StringRedisTemplate> getStringRedisTemplateInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<StringRedisTemplate>forFactoryMethod(RedisAutoConfiguration.class, "stringRedisTemplate", RedisConnectionFactory.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean("org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration", RedisAutoConfiguration.class).stringRedisTemplate(args.get(0)));
  }

  /**
   * Get the bean definition for 'stringRedisTemplate'.
   */
  public static BeanDefinition getStringRedisTemplateBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(StringRedisTemplate.class);
    beanDefinition.setFactoryBeanName("org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration");
    beanDefinition.setInstanceSupplier(getStringRedisTemplateInstanceSupplier());
    return beanDefinition;
  }
}
