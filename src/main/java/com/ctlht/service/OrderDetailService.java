package com.ctlht.service;

import com.ctlht.model.response.OrderDetailResponse;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailResponse> getOrderDetails(Long idOrder);

}
