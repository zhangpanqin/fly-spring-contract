package com.mflyyou.contract.order.sdk;

import com.mflyyou.contract.order.sdk.request.CreateOrderRequest;
import com.mflyyou.contract.order.sdk.response.CreateOrderResponse;

public interface OrderApi {
    CreateOrderResponse create(CreateOrderRequest createOrderRequest);
}
