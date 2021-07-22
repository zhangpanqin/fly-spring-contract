package com.mflyyou.contract.order;

import com.mflyyou.contract.order.contract.order.OrderService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@ActiveProfiles("test")
public class MockBeanConfiguration {
    @Bean
    @Primary
    public OrderService mockOrderService() {
        return Mockito.mock(OrderService.class);
    }
}