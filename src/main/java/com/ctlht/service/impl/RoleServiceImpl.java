package com.ctlht.service.impl;

import com.ctlht.entity.RoleEntity;
import com.ctlht.model.mapper.RoleMapper;
import com.ctlht.model.response.RoleResponse;
import com.ctlht.repository.RoleRepository;
import com.ctlht.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public List<RoleResponse> findAll() {

        List<RoleResponse> roleResponses = new ArrayList<>();

        List<RoleEntity> roleEntities = roleRepository.findAll();
        for(RoleEntity roleEntity : roleEntities){
            roleResponses.add(roleMapper.toResponse(roleEntity));
        }
        return roleResponses;
    }
}
