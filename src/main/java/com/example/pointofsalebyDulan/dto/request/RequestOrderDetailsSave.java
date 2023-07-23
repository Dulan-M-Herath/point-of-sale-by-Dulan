package com.example.pointofsalebyDulan.dto.request;


import com.example.pointofsalebyDulan.entity.Item;
import com.example.pointofsalebyDulan.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetailsSave {

    private String itemName;
    private double qty;
    private double amount;
    private int items;
}
