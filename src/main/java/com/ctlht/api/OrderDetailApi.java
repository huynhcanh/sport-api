package com.ctlht.api;

import com.ctlht.model.response.OrderDetailResponse;
import com.ctlht.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderDetailApi {

    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("/orderdetails")
    public List<OrderDetailResponse> getOrders(@RequestParam Long idOrder) {
        return orderDetailService.getOrderDetails(idOrder);
    }
}

