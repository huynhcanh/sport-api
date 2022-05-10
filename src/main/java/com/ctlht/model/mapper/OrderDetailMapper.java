package com.ctlht.model.mapper;

import com.ctlht.entity.OrderDetailEntity;
import com.ctlht.model.response.OrderDetailResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailMapper {
    @Autowired
    private ModelMapper modelMapper;

    public OrderDetailResponse toReponse(OrderDetailEntity entity) {
        OrderDetailResponse orderDetailResponse = modelMapper.map(entity, OrderDetailResponse.class);
        return orderDetailResponse;
    }

}
