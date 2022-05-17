package com.ctlht.api;

import com.ctlht.model.response.CategoryResponse;
import com.ctlht.model.response.RoleResponse;
import com.ctlht.service.CategoryService;
import com.ctlht.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleApi {

    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    public List<RoleResponse> getRoles() {
        return roleService.findAll();
    }
}

