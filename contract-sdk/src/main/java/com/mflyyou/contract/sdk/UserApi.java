package com.mflyyou.contract.sdk;

import com.mflyyou.contract.sdk.request.CreateUserRequest;
import com.mflyyou.contract.sdk.response.CreateUserResponse;
import com.mflyyou.contract.sdk.response.GetUserResponse;
import com.mflyyou.contract.sdk.response.UserResponse;

public interface UserApi {
    UserResponse getUser(Long userId);
    GetUserResponse getUserInfo(Long userId);
    CreateUserResponse createUser(CreateUserRequest createUserRequest);
}
