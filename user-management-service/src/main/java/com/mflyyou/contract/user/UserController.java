package com.mflyyou.contract.user;

import com.mflyyou.contract.sdk.UserApi;
import com.mflyyou.contract.sdk.response.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
