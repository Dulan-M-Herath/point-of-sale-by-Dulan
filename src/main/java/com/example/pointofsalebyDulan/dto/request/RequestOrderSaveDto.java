package com.example.pointofsalebyDulan.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RequestOrderSaveDto {

    private int customer;
    private Date date;
    private double amount;
    private List<RequestOrderDetailsSave> orderDetails;
}
