package com.example.crmchatbotbackend.controller;

import com.example.crmchatbotbackend.repository.BlacklistedTokenRepository;
import com.example.crmchatbotbackend.repository.UserRepository;
import com.example.crmchatbotbackend.security.JwtUtil;
import org.springframework.aot.generate.Generated;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Bean definitions for {@link AuthController}.
 */
@Generated
public class AuthController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'authController'.
   */
  private static BeanInstanceSupplier<AuthController> getAuthControllerInstanceSupplier() {
    return BeanInstanceSupplier.<AuthController>forConstructor(AuthenticationManager.class, JwtUtil.class, UserRepository.class, PasswordEncoder.class, BlacklistedTokenRepository.class)
            .withGenerator((registeredBean, args) -> new AuthController(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'authController'.
   */
  public static BeanDefinition getAuthControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthController.class);
    beanDefinition.setInstanceSupplier(getAuthControllerInstanceSupplier());
    return beanDefinition;
  }
}
