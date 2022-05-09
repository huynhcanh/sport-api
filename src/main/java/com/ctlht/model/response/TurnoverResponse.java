package com.ctlht.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnoverResponse {
    private String month;
    private Float totalMoneyOfMonth;
}
