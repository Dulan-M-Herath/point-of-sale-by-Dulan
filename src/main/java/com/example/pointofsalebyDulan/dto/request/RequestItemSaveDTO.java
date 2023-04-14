package com.example.pointofsalebyDulan.dto.request;

import com.example.pointofsalebyDulan.entity.enums.MeasuringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestItemSaveDTO {
    private String name;
    private MeasuringType measuringType;
    private double balanceQty;
    private double suplierPrice;
    private double sellingPrice;
}
