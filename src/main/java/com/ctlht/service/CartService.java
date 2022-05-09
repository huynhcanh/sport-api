package com.ctlht.service;

import com.ctlht.model.request.CartRequest;
import com.ctlht.model.response.CartResponse;
import com.ctlht.model.response.ProductSizeResponse;

import java.util.List;
import java.util.Map;

public interface CartService  {
    //all object (admin + customer)
    CartResponse insertCart(Map<String, Object> params);
    CartResponse updateCart(CartRequest cartRequest);
    void deleteCart(Long id);
    List<CartResponse> getCartsByUserId(Long id);
}
