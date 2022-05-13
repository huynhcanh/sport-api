package com.ctlht.repository.custom;

import com.ctlht.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserRepositoryCustom {
    List<UserEntity> getUsers(Map<String, String> params);
}
