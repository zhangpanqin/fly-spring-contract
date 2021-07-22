package com.mflyyou.contract.order;

import com.mflyyou.contract.order.sdk.OrderApi;
import com.mflyyou.contract.order.sdk.request.CreateOrderRequest;
import com.mflyyou.contract.order.sdk.response.CreateOrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController implements OrderApi {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderResponse create(@RequestBody CreateOrderRequest createOrderRequest){
        return orderService.create(createOrderRequest);
    }
}
