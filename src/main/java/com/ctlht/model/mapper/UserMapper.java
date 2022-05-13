package com.ctlht.model.mapper;

import com.ctlht.entity.UserEntity;
import com.ctlht.model.request.user.UserRequest;
import com.ctlht.model.response.UserResponse;
import com.ctlht.repository.RoleRepository;
import com.ctlht.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public UserResponse toResponse(UserEntity entity) {
        if(entity == null) return null;
        UserResponse userResponse = modelMapper.map(entity, UserResponse.class);
        return userResponse;
    }

    public UserEntity toEntity(UserRequest userRequest) {
        UserEntity userEntity=null;
        // add
        if(userRequest.getId() == null){

        }
        //update
        else{
            userEntity = userRepository.findById(userRequest.getId()).get();
            String pass = userRequest.getPassword();
            String name = userRequest.getName();
            String phone = userRequest.getPhone();
            String roleCode = userRequest.getRoleCode();
            if(pass!= null){
                userEntity.setPassword(pass);
            }
            if(name!= null){
                userEntity.setName(name);
            }
            if(phone!= null){
                userEntity.setPhone(phone);
            }
            if(roleCode!= null){
                userEntity.setRole(roleRepository.findByCode(roleCode));
            }
            userEntity.setCreatedDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        }
        return userEntity;
    }
}
