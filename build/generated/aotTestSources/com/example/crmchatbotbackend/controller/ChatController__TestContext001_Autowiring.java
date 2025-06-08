package com.example.crmchatbotbackend.controller;

import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ChatController}.
 */
@Generated
public class ChatController__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ChatController apply(RegisteredBean registeredBean, ChatController instance) {
    AutowiredFieldValueResolver.forRequiredField("chatRepository").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("userRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
