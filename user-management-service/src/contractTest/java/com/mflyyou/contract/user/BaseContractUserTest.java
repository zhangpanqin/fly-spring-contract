package com.mflyyou.contract.user;

import com.mflyyou.contract.BaseContractTest;
import com.mflyyou.contract.sdk.response.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class BaseContractUserTest extends BaseContractTest {
    @Autowired
    private UserService userService;

    @BeforeEach
    public void setup() {
        create();
    }

    private void create() {
        when(userService.getUser(anyLong()))
                .thenReturn(UserResponse.builder()
                        .userId(1111L)
                        .orderId(2222L)
                        .build());
    }
}
