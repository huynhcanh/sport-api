package com.ctlht.model.mapper;

import com.ctlht.entity.CartEntity;
import com.ctlht.model.request.CartRequest;
import com.ctlht.model.response.CartResponse;
import com.ctlht.repository.CartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CartMapper {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductSizeMapper productSizeMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ModelMapper modelMapper;

    public CartResponse toResponse(CartEntity cartEntity) {
        CartResponse cartResponse = modelMapper.map(cartEntity, CartResponse.class);
        return cartResponse;
    }

    public CartEntity toEntity(CartRequest cartRequest)
    {
        return null;
    }
}
