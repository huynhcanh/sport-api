package com.ctlht.api;

import com.ctlht.model.response.OrderResponse;
import com.ctlht.model.response.TurnoverResponse;
import com.ctlht.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class OrderApi {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public List<OrderResponse> getOrders(@RequestParam(required = false) Map<String, String> params) {
        return orderService.getOrdersByFields(params);
    }

    @PostMapping("/order")
    public OrderResponse insertOrderByUser(@RequestParam Map<String, Object> params) {
        return orderService.insertOrderToAllCartByUser(params);
    }

    //Turnover of Order
    @GetMapping("/orders/turnover/{month}")
    public TurnoverResponse getTotalOfOrder(@PathVariable String month) {
        return orderService.getOrdersTurnOverByCurrentMonth(month);
    }

    //Total order in day
    @GetMapping("/orders/total/{day}")
    public int countOrdersByDay(@PathVariable String day) {
        return orderService.countOrdersByDay(day);
    }

}

