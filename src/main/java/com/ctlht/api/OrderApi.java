package com.ctlht.api;

import com.ctlht.model.response.OrderResponse;
import com.ctlht.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class OrderApi {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public List<OrderResponse> getOrdersByFields(@RequestParam(required = false) Map<String, String> params) {
        return orderService.getOrdersByFields(params);
    }

}

