package com.mflyyou.contract.sdk;

import com.mflyyou.contract.sdk.request.CreateOrderRequest;
import com.mflyyou.contract.sdk.response.CreateOrderResponse;

public interface OrderApi {
    CreateOrderResponse create(CreateOrderRequest createOrderRequest);
}
