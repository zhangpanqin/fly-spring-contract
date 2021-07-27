package com.mflyyou.contract.user;

import brave.Tracer;
import com.mflyyou.contract.sdk.request.CreateOrderRequest;
import com.mflyyou.contract.sdk.request.CreateUserRequest;
import com.mflyyou.contract.sdk.response.CreateOrderResponse;
import com.mflyyou.contract.sdk.response.CreateUserResponse;
import com.mflyyou.contract.sdk.response.GetUserResponse;
import com.mflyyou.contract.sdk.response.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
public class UserService {
    private static final String CACHE_NAME = "REDIS_USER_INFO";
    private final Tracer tracer;
    private final OrderClient orderClient;
    private final UserRepository userRepository;
    private final RedisTemplate<String, String> redisTemplate;

    public UserService(Tracer tracer, OrderClient orderClient, UserRepository userRepository, RedisTemplate<String, String> redisTemplate) {
        this.tracer = tracer;
        this.orderClient = orderClient;
        this.userRepository = userRepository;
        this.redisTemplate = redisTemplate;
    }

    public UserResponse getUser(Long userId) {
        log.info("traceId: {}",tracer.currentSpan().context().traceIdString());
        CreateOrderResponse createOrderResponse = orderClient.create(CreateOrderRequest.builder()
                .userId(userId)
                .build());
        return UserResponse.builder()
                .userId(userId)
                .orderId(createOrderResponse.getId())
                .build();
    }

    @CacheEvict(value = CACHE_NAME, allEntries = true)
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(ThreadLocalRandom.current().nextLong());
        userEntity.setUsername(createUserRequest.getUsername());
        userRepository.save(userEntity);
        return CreateUserResponse.builder()
                .id(userEntity.getId())
                .build();
    }

    @Cacheable(value = CACHE_NAME)
    public GetUserResponse getUserInfo(Long id) {
        log.info("执行了,{}", redisTemplate.opsForValue().get("key22"));

        return userRepository.findById(id).map(userEntity -> GetUserResponse.builder()
                .username(userEntity.getUsername())
                .id(userEntity.getId())
                .build())
                .orElseThrow(() -> new RuntimeException("查询的数据不存在"));
    }
}
