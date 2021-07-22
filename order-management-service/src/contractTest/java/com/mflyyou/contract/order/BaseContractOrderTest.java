package com.mflyyou.contract.order;

import com.mflyyou.contract.order.contract.order.OrderService;
import com.mflyyou.contract.order.sdk.request.CreateOrderRequest;
import com.mflyyou.contract.order.sdk.response.CreateOrderResponse;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BaseContractOrderTest extends BaseContractTest {
    @Autowired
    private OrderService orderService;

    @BeforeEach
    public void setup() {
        create();
    }
    private void create(){
        when(orderService.create(any(CreateOrderRequest.class)))
                .thenReturn(CreateOrderResponse.builder()
                        .id(1L)
                        .build());
    }
}
