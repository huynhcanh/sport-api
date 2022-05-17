package com.ctlht.model.mapper;

import com.ctlht.constant.web.SystemConstant;
import com.ctlht.entity.UserEntity;
import com.ctlht.model.request.user.UserRequest;
import com.ctlht.model.response.UserResponse;
import com.ctlht.repository.RoleRepository;
import com.ctlht.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
            userEntity=new UserEntity();
//            // client không cho các field này empty
            userEntity.setName(userRequest.getName());
            userEntity.setEmail(userRequest.getEmail());
            userEntity.setPassword(userRequest.getPassword());
            userEntity.setPhone(userRequest.getPhone());
            userEntity.setRole(roleRepository.findByCode(userRequest.getRoleCode()));
            MultipartFile file = userRequest.getImage();
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
            String fileName= date + file.getOriginalFilename();
//            // đẩy image lên thư mục
            Path fileNameAndPath = Paths.get(SystemConstant.UPLOAD_IMG_DIR_USER, fileName);
            try{
                Files.write(fileNameAndPath,file.getBytes());
            }catch (IOException e){
                e.printStackTrace();
            }
            userEntity.setImage(fileName);
        }
        //update
        else{
            userEntity = userRepository.findById(userRequest.getId()).get();
            userEntity.setEmail(userRequest.getEmail());
            userEntity.setName(userRequest.getName());
            userEntity.setPassword(userRequest.getPassword());
            userEntity.setPhone(userRequest.getPhone());
            userEntity.setRole(roleRepository.findByCode(userRequest.getRoleCode()));
        }
        return userEntity;
    }
}
