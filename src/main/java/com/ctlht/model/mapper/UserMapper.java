package com.ctlht.model.mapper;

import com.ctlht.entity.CategoryEntity;
import com.ctlht.entity.UserEntity;
import com.ctlht.model.response.CategoryResponse;
import com.ctlht.model.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;

    public UserResponse toReponse(UserEntity entity) {
        UserResponse userResponse = modelMapper.map(entity, UserResponse.class);
        return userResponse;
    }
}
