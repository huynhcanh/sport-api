package com.ctlht.service;

import com.ctlht.model.response.OrderDetailResponse;
import com.ctlht.model.response.OrderResponse;
import com.ctlht.model.response.TurnoverResponse;

import java.util.List;
import java.util.Map;

public interface OrderDetailService {
    List<OrderDetailResponse> getOrderDetails(Long idOrder);

}
