package com.ctlht.service.impl;

import com.ctlht.entity.CartEntity;
import com.ctlht.entity.ProductSizeEntity;
import com.ctlht.entity.UserEntity;
import com.ctlht.model.mapper.CartMapper;
import com.ctlht.model.request.CartRequest;
import com.ctlht.model.response.CartResponse;
import com.ctlht.repository.CartRepository;
import com.ctlht.repository.ProductSizeRepository;
import com.ctlht.repository.UserRepository;
import com.ctlht.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    CartMapper cartMapper;

    @Override
    public CartResponse insertCart(Map<String, Object> params) {
        CartEntity cartEntity = new CartEntity();
        //protduct size
        Long productId = Long.valueOf(params.getOrDefault("productId", null).toString());
        String sizeCode = (String) params.getOrDefault("sizeCode", null);
        ProductSizeEntity productSizeEntity = productSizeRepository.findByProductIdAndSizeCode(productId, sizeCode);
        System.out.println(productSizeEntity.getProduct().getId());
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
        if (cartRequest.getQuantity() != null) {
            cartEntity.setQuantity(cartRequest.getQuantity());
            ProductSizeEntity productSizeEntity = productSizeRepository.findByProductIdAndSizeCode(cartRequest.getProductId(), cartRequest.getSizeCode());
            cartEntity.setTotalMoney(cartRequest.getQuantity() * productSizeEntity.getProduct().getSalePrice());
        }
        if (cartRequest.getSizeCode() != null) {
            ProductSizeEntity productSizeEntity = productSizeRepository.findByProductIdAndSizeCode(cartEntity.getProductsize().getProduct().getId()
                    , cartRequest.getSizeCode());
            cartEntity.setProductsize(productSizeEntity);
        }
        return cartMapper.toResponse(cartRepository.save(cartEntity));
    }

    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public List<CartResponse> getCartsByUserId(Long id) {
        List<CartResponse> cartResponses = new ArrayList<CartResponse>();

        List<CartEntity> cartEntities = cartRepository.findAllByUserId(id);
        for (CartEntity entity : cartEntities) {
            cartResponses.add(cartMapper.toResponse(entity));
        }
        return cartResponses;
    }

}
