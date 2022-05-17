package com.ctlht.api;

import com.ctlht.model.response.SizeResponse;
import com.ctlht.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SizeApi {

    @Autowired
    SizeService sizeService;

    @GetMapping("/sizes")
    public List<SizeResponse> getSizes() {
        List<SizeResponse> sizeResponses = sizeService.findAll();
        return sizeResponses;
    }
}
