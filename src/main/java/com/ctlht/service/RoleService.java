package com.ctlht.service;

import com.ctlht.model.response.RoleResponse;

import java.util.List;

public interface RoleService {
    List<RoleResponse> findAll();
}
