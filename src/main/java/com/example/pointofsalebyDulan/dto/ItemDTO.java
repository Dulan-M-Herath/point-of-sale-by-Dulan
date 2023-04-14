package com.example.pointofsalebyDulan.dto;

import com.example.pointofsalebyDulan.entity.enums.MeasuringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {

    private int id;
    private String name;
    private MeasuringType measuringType;
    private double balanceQty;
    private double suplierPrice;
    private double sellingPrice;
    private boolean activeStatus;
}
