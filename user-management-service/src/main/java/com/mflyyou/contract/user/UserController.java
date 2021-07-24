package com.mflyyou.contract.user;

import com.mflyyou.contract.sdk.UserApi;
import com.mflyyou.contract.sdk.request.CreateUserRequest;
import com.mflyyou.contract.sdk.response.CreateUserResponse;
import com.mflyyou.contract.sdk.response.GetUserResponse;
import com.mflyyou.contract.sdk.response.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController implements UserApi {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Override
    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @Override
    @PostMapping("")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest) {
        return userService.createUser(createUserRequest);
    }

    @Override
    @GetMapping("/v2/{id}")
    public GetUserResponse getUserInfo(@PathVariable Long id) {
        return userService.getUserInfo(id);
    }

}
