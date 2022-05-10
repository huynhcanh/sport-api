package com.ctlht.service.impl;

import com.ctlht.entity.*;
import com.ctlht.enums.MonthEnums;
import com.ctlht.model.mapper.OrderMapper;
import com.ctlht.model.response.OrderResponse;
import com.ctlht.model.response.TurnoverResponse;
import com.ctlht.repository.*;
import com.ctlht.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ProductSizeRepository productSizeRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

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

    @Override
    public OrderResponse insertOrderToAllCartByUser(Map<String, Object> params) {
        OrderEntity orderEntity = new OrderEntity();
        String adddress = (String) params.getOrDefault("adddress", null);
        orderEntity.setAdddress(adddress);
        orderEntity.setCreatedDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

        //user have carts
        Long userId = Long.valueOf(params.getOrDefault("userId", null).toString());
        UserEntity userEntity = userRepository.findById(userId).get();
        orderEntity.setUser(userEntity);

        //accept carts -> order details -> delete carts
        List<CartEntity> cartEntities = cartRepository.findAllByUserId(userId);
        Float totalMoney = 0F;
        orderRepository.save(orderEntity);
        for (CartEntity cartEntity : cartEntities) {
            ProductSizeEntity productSizeEntity = productSizeRepository.findById(cartEntity.getProductsize().getId()).get();
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setOrder(orderEntity); //id
            orderDetailEntity.setProductsize(cartEntity.getProductsize());
            orderDetailEntity.setQuantity(cartEntity.getQuantity());
            productSizeEntity.setQuantity(productSizeEntity.getQuantity() - cartEntity.getQuantity());
            orderDetailEntity.setTotalMoney(cartEntity.getTotalMoney());
            totalMoney = totalMoney + cartEntity.getTotalMoney();
            orderDetailRepository.save(orderDetailEntity);
            cartRepository.deleteById(cartEntity.getId());
        }
        orderEntity.setTotalMoney(totalMoney);
        return orderMapper.toReponse(orderRepository.save(orderEntity));

    }

    @Override
    public TurnoverResponse getOrdersTurnOverByCurrentMonth(String month) {
        List<OrderEntity> orderEntities = orderRepository.getOrdersByCurrentMonth(month);
        TurnoverResponse turnoverResponse = new TurnoverResponse();
        Float totalMoney = 0F;
        for (OrderEntity item : orderEntities) {
            totalMoney += item.getTotalMoney();
        }
        for(MonthEnums m : MonthEnums.values()) {
            if(m.getValue().equals(month)) {
                turnoverResponse.setMonth("Turnover in " + m);
                break;
            }
        }
        turnoverResponse.setTotalMoneyOfMonth(totalMoney);
        return turnoverResponse;
    }

    @Override
    public int countOrdersByDay(String day) {
        return orderRepository.countOrdersByDay(day).size();
    }
}
