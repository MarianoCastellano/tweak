package com.gm.tweak.application;

import com.gm.tweak.application.service.UserRegisterService;
import com.gm.tweak.domain.user.UserRepository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ServiceConfiguration {

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public UserRegisterService userRegisterService(UserRepository userRepository) {
        return new UserRegisterService(userRepository);
    }

}
