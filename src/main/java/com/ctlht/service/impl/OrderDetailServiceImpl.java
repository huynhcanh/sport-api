package com.ctlht.service.impl;

import com.ctlht.entity.OrderDetailEntity;
import com.ctlht.model.mapper.OrderDetailMapper;
import com.ctlht.model.response.OrderDetailResponse;
import com.ctlht.repository.OrderDetailRepository;
import com.ctlht.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrderDetailResponse> getOrderDetails(Long idOrder) {
        List<OrderDetailEntity> orderDetailEntities = orderDetailRepository.findAllByOrderId(idOrder);
        List<OrderDetailResponse> orderDetailResponses = new ArrayList<>();
        for(OrderDetailEntity item: orderDetailEntities) {
            orderDetailResponses.add(orderDetailMapper.toReponse(item));
        }
        return orderDetailResponses;
    }
}
