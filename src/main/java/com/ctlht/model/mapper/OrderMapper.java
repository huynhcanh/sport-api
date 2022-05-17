package com.ctlht.model.mapper;

import com.ctlht.entity.OrderEntity;
import com.ctlht.model.response.OrderResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    @Autowired
    private ModelMapper modelMapper;

    public OrderResponse toReponse(OrderEntity entity) {
        OrderResponse orderResponse = modelMapper.map(entity, OrderResponse.class);
        return orderResponse;
    }

}
