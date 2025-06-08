package com.example.crmchatbotbackend.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ChatController}.
 */
@Generated
public class ChatController__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'chatController'.
   */
  public static BeanDefinition getChatControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ChatController.class);
    InstanceSupplier<ChatController> instanceSupplier = InstanceSupplier.using(ChatController::new);
    instanceSupplier = instanceSupplier.andThen(ChatController__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
