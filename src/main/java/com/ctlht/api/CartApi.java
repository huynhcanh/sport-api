package com.ctlht.api;


import com.ctlht.model.mapper.ProductMapper;
import com.ctlht.model.mapper.ProductSizeMapper;
import com.ctlht.model.request.CartRequest;
import com.ctlht.model.response.CartResponse;
import com.ctlht.model.response.ProductSizeResponse;
import com.ctlht.repository.ProductRepository;
import com.ctlht.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CartApi {

    @Autowired
    CartService cartService;

    @GetMapping("/carts/{id}")
    public List<CartResponse> getCartsByUserId(@PathVariable Long id){
        return cartService.getCartsByUserId(id);
    }

    @PostMapping("/cart")
    public CartResponse insertCart(@RequestParam Map<String,Object> params) {
        CartResponse cartResponse = cartService.insertCart(params);
        return cartResponse;
    }

    @PutMapping("/cart")
    public CartResponse updateCart(@RequestBody CartRequest cartRequest) {
        CartResponse cartResponse = cartService.updateCart(cartRequest);
        return cartResponse;
    }

    @DeleteMapping("/cart/{id}")
    public void deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
    }
}
