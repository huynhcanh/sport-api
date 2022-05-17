package com.ctlht.service.impl;

import com.ctlht.entity.SizeEntity;
import com.ctlht.model.mapper.SizeMapper;
import com.ctlht.model.response.SizeResponse;
import com.ctlht.repository.SizeRepository;
import com.ctlht.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    SizeRepository sizeReponsitory;

    @Autowired
    SizeMapper sizeMapper;

    @Override
    public List<SizeResponse> findAll() {

        List<SizeResponse> sizeResponses = new ArrayList<>();

        List<SizeEntity> sizeEntities = sizeReponsitory.findAll();
        for(SizeEntity sizeEntity : sizeEntities){
            sizeResponses.add(sizeMapper.toReponse(sizeEntity));
        }
        return sizeResponses;
    }
}