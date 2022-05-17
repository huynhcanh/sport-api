package com.ctlht.api;

import com.ctlht.model.request.user.UserRequest;
import com.ctlht.model.response.UserResponse;
import com.ctlht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class UserApi {

    @Autowired
    public UserService service;

    @PostMapping("/user/register")
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return service.register(userRequest);
    }

    @PostMapping("/user/login")
    public UserResponse login(@RequestBody UserRequest userRequest) {
        return service.login(userRequest);
    }

    @GetMapping("/user")
    public UserResponse getUserByEmail(@RequestParam String email) {
        return service.findUserByEmail(email);
    }

    @PutMapping("/user")
    public UserResponse updateUser(@RequestBody UserRequest userRequest) {
        return service.update(userRequest);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable Long id) {
        service.deleteById(id);
    }

    // PAGINATE  OK 2
    @GetMapping("/users")
    public List<UserResponse> getUsersByPage(@RequestParam(required = false) Map<String, String> params) {
        return service.findUsersByParams(params);
    }

    @GetMapping("/user/count")
    public long getTotalItem() {
        return service.getTotalItem();
    }
}
