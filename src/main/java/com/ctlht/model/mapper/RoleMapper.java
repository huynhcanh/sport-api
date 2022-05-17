package com.ctlht.model.mapper;

import com.ctlht.entity.RoleEntity;
import com.ctlht.model.response.RoleResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    @Autowired
    private ModelMapper modelMapper;

    public RoleResponse toResponse(RoleEntity entity) {
        RoleResponse roleResponse = modelMapper.map(entity, RoleResponse.class);
        return roleResponse;
    }
}
