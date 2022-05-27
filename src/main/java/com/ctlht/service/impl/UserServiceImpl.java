package com.ctlht.service.impl;

import com.ctlht.entity.UserEntity;
import com.ctlht.model.mapper.UserMapper;
import com.ctlht.model.request.user.UserRequest;
import com.ctlht.model.response.UserResponse;
import com.ctlht.repository.RoleRepository;
import com.ctlht.repository.UserRepository;
import com.ctlht.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.ctlht.constant.web.RoleConstant.CUSTOMER;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public UserResponse register(UserRequest userRequest) {
        if (userRepository.findByEmail(userRequest.getEmail()) != null) return null; // tồn tại email trong db
        UserEntity userEntity = modelMapper.map(userRequest, UserEntity.class);
        userEntity.setCreatedDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        userEntity.setRole(roleRepository.findByCode(CUSTOMER));
        return userMapper.toResponse(userRepository.save(userEntity));
    }

    // LOGIN
    @Override
    public UserResponse login(UserRequest userRequest) {
        UserEntity userEntity = userRepository.findByEmail(userRequest.getEmail());
        if (userEntity != null) {// tồn tại email trong db
            if (!userEntity.getPassword().equals(userRequest.getPassword())) return null;
        } else return null;
        return userMapper.toResponse(userEntity);
    }


    @Override
    public UserResponse findUserByEmail(String email) {
        return userMapper.toResponse(userRepository.findByEmail(email));
    }


    @Override
    public List<UserResponse> findUsersByParams(Map<String, String> param) {
        List<UserEntity> users = (List<UserEntity>) userRepository.getUsers(param);
        List<UserResponse> userResponses = new ArrayList<>();
        for (UserEntity userEntity : users) {
            userResponses.add(userMapper.toResponse(userEntity));
        }
        return userResponses;
    }

    @Override
    @Transactional
    public void deleteUsers(long[] ids) {
        for (long id : ids) {
            userRepository.deleteById(id);
        }
    }

    @Override
    @Transactional
    public UserResponse updateOrAdd(UserRequest userRequest) {
        UserEntity userEntity = userRepository.save(userMapper.toEntity(userRequest));
        return userMapper.toResponse(userEntity);
    }

    @Override
    public long getTotalItem() {
        return userRepository.count();
    }
}