package com.ctlht.model.mapper;


import com.ctlht.entity.SizeEntity;
import com.ctlht.model.response.SizeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SizeMapper {

    @Autowired
    private ModelMapper modelMapper;

    public SizeResponse toReponse(SizeEntity entity) {
        return modelMapper.map(entity, SizeResponse.class);
    }
}
