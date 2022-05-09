package com.ctlht.service.impl;

import com.ctlht.entity.CartEntity;
import com.ctlht.entity.ProductSizeEntity;
import com.ctlht.entity.UserEntity;
import com.ctlht.model.mapper.CartMapper;
import com.ctlht.model.mapper.ProductSizeMapper;
import com.ctlht.model.request.CartRequest;
import com.ctlht.model.response.CartResponse;
import com.ctlht.repository.CartRepository;
import com.ctlht.repository.ProductSizeRepository;
import com.ctlht.repository.UserRepository;
import com.ctlht.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductSizeRepository productSizeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductSizeMapper productSizeMapper;

    @Autowired
    CartMapper cartMapper;

    @Override
    public CartResponse insertCart(Map<String, Object> params) {
        CartEntity cartEntity = new CartEntity();
        //protduct size
        Long productId = Long.valueOf(params.getOrDefault("productId", null).toString());
        String sizeCode = (String) params.getOrDefault("sizeCode", null);
        ProductSizeEntity productSizeEntity = productSizeRepository.findByProductIdAndSizeCode(productId, sizeCode);

        //user
        Long userId = Long.valueOf(params.getOrDefault("userId", null).toString());
        UserEntity userEntity = userRepository.findById(userId).get();

        //cart
        Integer quantity = Integer.valueOf(params.getOrDefault("quantity", null).toString());
        //productSizeEntity.setQuantity(productSizeEntity.getQuantity() - quantity); --> order accept

        cartEntity.setProductsize(productSizeEntity);
        cartEntity.setUser(userEntity);
        cartEntity.setQuantity(quantity);
        cartEntity.setTotalMoney(productSizeEntity.getProduct().getSalePrice() * quantity);

        return cartMapper.toResponse(cartRepository.save(cartEntity));
    }

    @Override
    public CartResponse updateCart(CartRequest cartRequest) {
        CartEntity cartEntity = cartRepository.findById(cartRequest.getId()).get();
        cartEntity.setQuantity(cartRequest.getQuantity());


        return null;
    }
}
