package com.ctlht.service;

import com.ctlht.model.request.user.UserRequest;
import com.ctlht.model.response.UserResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface UserService {
    UserResponse register(UserRequest userRequest);
    UserResponse findUserByEmail(String email);
    UserResponse login(UserRequest userRequest);
    List<UserResponse> findUsersByParams(Map<String, String> param);
    void deleteUsers(long[] ids);
    UserResponse updateOrAdd(UserRequest userRequest);
    long getTotalItem();
}
