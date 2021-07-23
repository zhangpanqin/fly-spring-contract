package com.mflyyou.contract;

import com.mflyyou.contract.user.UserService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MockBeanConfiguration {
    @Bean
    @Primary
    public UserService mockOrderService() {
        return Mockito.mock(UserService.class);
    }
}