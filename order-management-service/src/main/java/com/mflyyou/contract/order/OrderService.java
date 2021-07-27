package com.mflyyou.contract.order;

import brave.Tracer;
import com.mflyyou.contract.sdk.request.CreateOrderRequest;
import com.mflyyou.contract.sdk.response.CreateOrderResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class OrderService {
    private final Tracer tracer;

    public OrderService(Tracer tracer) {
        this.tracer = tracer;
    }

    public CreateOrderResponse create(CreateOrderRequest request) {
        log.info("traceId: {}",tracer.currentSpan().context().traceIdString());
        if (request.getUserId()!=null && request.getUserId() % 2==0) {
            throw new RuntimeException("故意抛出异常");
        }
        return CreateOrderResponse.builder()
                .id(2L)
                .build();
    }
}
