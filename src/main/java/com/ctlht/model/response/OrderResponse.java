package com.ctlht.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Float totalMoney;
    private String adddress;
    private UserResponse user;
    private Date createdDate;
}
