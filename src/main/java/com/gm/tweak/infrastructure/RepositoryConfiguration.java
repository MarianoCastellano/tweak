package com.gm.tweak.infrastructure;

import com.gm.tweak.domain.user.UserRepository;
import com.gm.tweak.infrastructure.repository.UserMemoryRepository;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RepositoryConfiguration {

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public UserRepository userRepository() {
        return new UserMemoryRepository();
    }
}
