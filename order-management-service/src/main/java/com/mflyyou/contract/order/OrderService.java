package com.mflyyou.contract.order;

import com.mflyyou.contract.order.sdk.request.CreateOrderRequest;
import com.mflyyou.contract.order.sdk.response.CreateOrderResponse;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    public CreateOrderResponse create(CreateOrderRequest request) {
        return CreateOrderResponse.builder()
                .id(2L)
                .build();
    }
}
