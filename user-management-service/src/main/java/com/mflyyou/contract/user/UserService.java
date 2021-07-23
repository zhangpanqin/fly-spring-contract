package com.mflyyou.contract.user;

import com.mflyyou.contract.sdk.request.CreateOrderRequest;
import com.mflyyou.contract.sdk.response.CreateOrderResponse;
import com.mflyyou.contract.sdk.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final OrderClient orderClient;

    public UserService(OrderClient orderClient) {
        this.orderClient = orderClient;
    }

    public UserResponse getUser(Long userId) {
        CreateOrderResponse createOrderResponse = orderClient.create(CreateOrderRequest.builder().build());
        return UserResponse.builder()
                .userId(userId)
                .orderId(createOrderResponse.getId())
                .build();
    }
}
