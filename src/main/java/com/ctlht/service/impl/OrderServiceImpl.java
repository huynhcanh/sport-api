package com.ctlht.service.impl;

import com.ctlht.entity.CategoryEntity;
import com.ctlht.entity.OrderEntity;
import com.ctlht.model.mapper.CategoryMapper;
import com.ctlht.model.mapper.OrderMapper;
import com.ctlht.model.response.CategoryResponse;
import com.ctlht.model.response.OrderResponse;
import com.ctlht.repository.CategoryRepository;
import com.ctlht.repository.OrderRepository;
import com.ctlht.service.CategoryService;
import com.ctlht.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<OrderResponse> getOrdersByFields(Map<String, String> params) {
        List<OrderResponse> orderResponses = new ArrayList<>();

        List<OrderEntity> orderEntities = orderRepository.getOrdersByFields(params);
        for (OrderEntity orderEntity : orderEntities) {
            orderResponses.add(orderMapper.toReponse(orderEntity));
        }
        return orderResponses;
    }
}
