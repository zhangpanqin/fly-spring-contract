package com.mflyyou.contract.user;

import com.mflyyou.contract.BaseContractTest;
import com.mflyyou.contract.sdk.request.CreateOrderRequest;
import com.mflyyou.contract.sdk.response.CreateOrderResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.isA;

public class OrderConsumerClient extends BaseContractTest {
    @Autowired
    private OrderClient orderClient;

    @Test
    void createOrder() {
        CreateOrderResponse createOrderResponse = orderClient.create(CreateOrderRequest.builder()
                .orderDescription("aaa")
                .price(new BigDecimal("1.0"))
                .build());
        assertThat(createOrderResponse, allOf(
                hasProperty("id", isA(Long.class))
        ));
    }
}
