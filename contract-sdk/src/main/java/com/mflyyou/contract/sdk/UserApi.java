package com.mflyyou.contract.sdk;

import com.mflyyou.contract.sdk.response.UserResponse;

public interface UserApi {
    UserResponse getUser(Long userId);
}
